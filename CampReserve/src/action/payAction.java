package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProDAO;
import dao.reserveDAO;
import vo.ProVO;
import vo.campSiteVo;
import vo.priceInfoVo;
import vo.reserveVo;

public class payAction implements Action {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 해야될것 : 로그인 정보 받아와서 로그인 없으면 로그인 페이지로 넘어가기		
		String id = (String) req.getSession().getAttribute("userId");
		
		reserveVo rvo = (reserveVo) req.getSession().getAttribute("rvo");
		campSiteVo cvo = (campSiteVo) req.getSession().getAttribute("cvo");
		priceInfoVo pvo = (priceInfoVo) req.getSession().getAttribute("pvo");

		if(id == null) {
			return "/member/login.jsp";			
		}else if(rvo !=null && cvo !=null && pvo!=null && id != null) {
			ProDAO proDao = new ProDAO();
			ProVO proVo = proDao.getOneData(id);
			
			req.getSession().setAttribute("proVo", proVo);
			req.getSession().setAttribute("rvo", rvo);
			req.getSession().setAttribute("pvo", pvo);
			req.getSession().setAttribute("cvo", cvo);
			return "/camp/pay.jsp";
		}else {
			return "/camp/select.jsp";
		}
	}	
}
