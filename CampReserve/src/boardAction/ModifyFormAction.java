package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReviewDAO;
import vo.ReviewVO;

public class ModifyFormAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String no = req.getParameter("rno");
		
 		if(no!=null)
 		{
			int rno = Integer.parseInt(no);
			ReviewDAO dao = new ReviewDAO();
			ReviewVO vo = new ReviewVO(); 
 			vo = dao.getData(rno);
 			
 			req.setAttribute("vo", vo);
 			
 			return "/board/modify.jsp";
 		}
 		else
 		{
 			return "/board/detail.jsp";
 		}
	}

}
