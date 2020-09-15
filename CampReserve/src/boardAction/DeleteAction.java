package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReviewDAO;


public class DeleteAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String no = req.getParameter("rno");
		if(no!=null)
		{
			int rno = Integer.parseInt(no);
		  	ReviewDAO dao = new ReviewDAO();
			dao.deleteData(rno);

			return "/board/deleteOk.jsp";
		}
		else
		{
			return "/board/list.jsp";
		}

	}

}
