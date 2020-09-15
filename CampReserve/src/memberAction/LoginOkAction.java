package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ProDAO;
import vo.ProVO;
import vo.campSiteVo;
import vo.priceInfoVo;
import vo.reserveVo;

public class LoginOkAction implements Action 
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		ProDAO dao = new ProDAO();
		ProVO vo = new ProVO();

		String ck1 = req.getParameter("ide");
		String ck2 = req.getParameter("pws");
		
		vo.setId(ck1);
		vo.setPw(ck2);
		
		boolean loginCheck = dao.checkLogin(vo);
		
		
		reserveVo rvo = (reserveVo) req.getSession().getAttribute("rvo");
		campSiteVo cvo = (campSiteVo) req.getSession().getAttribute("cvo");
		
		if(loginCheck && (rvo == null || cvo == null))
		{
			req.setAttribute("vo", vo);
			return "./member/loginOk.jsp";
		}else if(loginCheck && rvo != null && cvo != null) {
			req.getSession().setAttribute("userId", vo.getId());			
			return "./camp/select.jsp";
		}else
		{
			return "./member/falseLogin.jsp";
		}
	}

}
