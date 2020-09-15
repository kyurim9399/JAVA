package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class confirmOkAction implements Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("rvo");
		req.getSession().removeAttribute("cvo");
		req.getSession().removeAttribute("pvo");
		req.getSession().removeAttribute("payVo");
		return "./board/main.jsp";
	}
}
