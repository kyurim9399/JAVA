package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import pageAction.MainAction;

@WebServlet("/home.do")
public class PageController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//페이지 흐름 제어
		String cmd = req.getParameter("cmd");
		
		Action model = null;
		
		String viewPage = null;

		if(cmd==null || cmd.equalsIgnoreCase("main"))
		{
			//전체 게시글 페이지
			model = new MainAction();
		}
		

		viewPage = model.execute(req, resp);
		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
