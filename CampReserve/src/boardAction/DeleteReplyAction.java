package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import vo.ReplyVO;


public class DeleteReplyAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String no = req.getParameter("rpno");
		if(no!=null)
		{
			int rpno = Integer.parseInt(no);
		  	ReplyDAO dao = new ReplyDAO();
		  	ReplyVO vo = dao.getData(rpno);
			dao.deleteData(rpno); 
			
			req.setAttribute("vo", vo);
			return "/board/deleteReplyOk.jsp";
		}
		else
		{
			return "/board/list.jsp";
		}

	}

}
