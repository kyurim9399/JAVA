package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReviewDAO;
import vo.ReviewVO;


public class ModifyWriteAction implements Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
	{
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String no = req.getParameter("rno");
		int score = Integer.parseInt(req.getParameter("score"));
		
		if(no!=null)
		{
			int rno = Integer.parseInt(no);
			
			ReviewDAO dao = new ReviewDAO();
			ReviewVO vo = new ReviewVO();
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setRno(rno);
			vo.setScore(score);
			
			dao.modifyData(vo);
			
			req.setAttribute("vo", vo);
			
			return "/board/modifyOk.jsp";
		}
		else
		{
			return "/board/list.jsp";
		}
	}

}
