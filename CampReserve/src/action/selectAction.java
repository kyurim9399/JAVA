package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CampSiteDao;
import dao.reserveDAO;
import vo.campSiteVo;
import vo.priceInfoVo;
import vo.reserveVo;

public class selectAction implements Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String siteCode = req.getParameter("siteCode");
		reserveVo rvo = (reserveVo) req.getSession().getAttribute("rvo");
	
		if(siteCode !=null && rvo!=null){
			CampSiteDao campDao = new CampSiteDao();
			priceInfoVo pvo = new priceInfoVo();
			campSiteVo cvo = campDao.getData(siteCode);

			rvo.setSiteCode(siteCode);

			// 날짜차이 구하기
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			int nights = 0;
			try {
				Date stdDate = transFormat.parse(rvo.getStdDate());
				Date endDate = transFormat.parse(rvo.getEndDate());
				nights = (int) ((endDate.getTime()-stdDate.getTime()) / (24*60*60*1000));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pvo.setNights(nights);
			
			
			pvo.setAddPpl(rvo.getTotal_p() - cvo.getMinPpl()); // 추가인원
			pvo.setAddPrice(pvo.getAddPpl() * 5000); // 추가인원에 따른 추가 금액
			
			pvo.setPrice1(cvo.getcPrice() * pvo.getNights()); 
			pvo.setPrice2(pvo.getAddPrice() * pvo.getNights());
		
			int sPrice = pvo.getPrice1() + pvo.getPrice2();
			
			rvo.setsPrice(sPrice);
			
			req.getSession().setAttribute("rvo", rvo);
			req.getSession().setAttribute("cvo", cvo);
			req.getSession().setAttribute("pvo", pvo);
			return "/camp/select.jsp";
		}else {
			return "/camp/reasults.jsp";
		}
	}
}
