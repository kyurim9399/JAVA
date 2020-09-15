package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReviewDAO;
import vo.ReviewVO;

public class WriteAction implements Action 
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String writer = req.getParameter("userId");
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		int score = Integer.parseInt(req.getParameter("score"));
		//contents = contents.replaceAll("br", "<br>");

		
		ReviewDAO dao = new ReviewDAO();
		ReviewVO vo = new ReviewVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setScore(score);
		
		dao.addData(vo);
		req.setAttribute("vo", vo);
	
		return "/board/writeOk.jsp";
	}

}
