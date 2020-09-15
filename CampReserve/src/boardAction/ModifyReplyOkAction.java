package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import vo.ReplyVO;

public class ModifyReplyOkAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		int rpno = Integer.parseInt(req.getParameter("rpno"));
		String contents = req.getParameter("rt");
		
		vo = dao.getData(rpno);
		vo.setContents(contents);
		dao.modifyReply(vo);
		
		req.setAttribute("vo", vo);
		
		return "/board/modifyreplyOk.jsp";
	}

}
