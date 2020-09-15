package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ProDAO;
import vo.ProVO;

public class RegisterOkAction implements Action 
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		
		ProDAO dao2 = new ProDAO();
		ProVO vo2 = new ProVO();
		
		String ID = req.getParameter("idc");
		vo2.setId(ID);
		vo2.setPw(req.getParameter("pw1"));
		vo2.setName(req.getParameter("cname"));
		vo2.setPhone(req.getParameter("pho"));
		dao2.insertMember(vo2);
		System.out.println(ID);

		
		return "./member/RegOk.jsp";
	}

}
