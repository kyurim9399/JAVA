package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PayInfoDao;
import dao.reserveDAO;
import vo.PayInfoVO;
import vo.ProVO;
import vo.campSiteVo;
import vo.priceInfoVo;
import vo.reserveVo;

public class confirmAction implements Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		ProVO proVo = (ProVO) req.getSession().getAttribute("proVo");
		reserveVo rvo = (reserveVo) req.getSession().getAttribute("rvo");
		String payInfo = req.getParameter("payInfo");

		if(proVo!=null && rvo !=null && payInfo != null){
			rvo.setId(proVo.getId());
			
			reserveDAO rDao = new reserveDAO();
			rvo.setNoRes(rDao.createNoRes());
			rDao.insertData(rvo);
			
			PayInfoVO payVo = new PayInfoVO();
			payVo.setNoRes(rvo.getNoRes());
			payVo.setpPrice(rvo.getsPrice());
			payVo.setpMethod(payInfo);
			if(payInfo.equals("무통장입금")) {
				payVo.setpState("N");				
			}else {
				payVo.setpState("Y");
			}
			
			PayInfoDao payDao = new PayInfoDao();
			payDao.insertData(payVo);
					
			req.getSession().setAttribute("rvo", rvo);
			req.getSession().setAttribute("payVo", payVo);
			return "/camp/confirm.jsp";
		}else {
			return "/camp/pay.jsp";
		}
	}	
}
