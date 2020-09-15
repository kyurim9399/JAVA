package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import vo.ReplyVO;

public class InsertReplyAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String id = req.getParameter("userId");
		String no = req.getParameter("rno");
		String contents = req.getParameter("rt");
		int depth = Integer.parseInt(req.getParameter("depth"));
		
		if(no!=null)
		{
			int rno = Integer.parseInt(no);
			
	/* 		out.println("bno : " + bno);
			out.println("contents : " + contents);
			out.println("id : " + id);
			
	 */ 	
	 		ReplyDAO rpdao = new ReplyDAO();
	 		ReplyVO rpvo = new ReplyVO();
	 		rpvo.setId(id);
	 		rpvo.setContents(contents);
	 		rpvo.setRno(rno);
	 		rpvo.setDepth(depth);
	 		rpvo.setReorder(rpdao.getReorder(rno));
	 		rpvo.setReparent(0);
	 		
	 		rpdao.insertReply(rpvo);
	 		
	 		req.setAttribute("rpvo", rpvo);

			return "/board/replyOk.jsp";
		}
		else
		{
			return "/board/list.jsp";
		}

	}

}
