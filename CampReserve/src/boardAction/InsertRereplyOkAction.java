package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import vo.ReplyVO;

public class InsertRereplyOkAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		ReplyDAO dao = new ReplyDAO();
		ReplyVO vo = new ReplyVO();
		int rpno = Integer.parseInt(req.getParameter("rpno"));
		String id = req.getParameter("userId");
		String contents = req.getParameter("retxt");
		
		vo = dao.getData(rpno);
		vo.setId(id);
		vo.setContents(contents);
		dao.insertRereply(vo);
		
		req.setAttribute("vo", vo);
		
		return "/board/rereplyOk.jsp";
	}

}
