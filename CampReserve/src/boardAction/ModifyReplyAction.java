package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import vo.ReplyVO;

public class ModifyReplyAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		ReplyDAO rpdao = new ReplyDAO();
		ReplyVO rpvo = new ReplyVO();
		int rpno = Integer.parseInt(req.getParameter("rpno"));
		
		rpvo = rpdao.getData(rpno);		
		
		rpvo.setContents(rpvo.getContents().replace("<br>", "\n"));
		
	 	req.setAttribute("rpvo", rpvo);

		return "/board/modifyReply.jsp";
	}

}
