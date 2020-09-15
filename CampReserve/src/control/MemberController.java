package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import memberAction.LoginAction;
import memberAction.LoginOkAction;
import memberAction.RegisterAction;
import memberAction.RegisterOkAction;

@WebServlet("/member.do")
public class MemberController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//페이지 흐름 제어
		String cmd = req.getParameter("cmd");
		Action model = null;
		
		String viewPage = null;

		if(cmd==null || cmd.equalsIgnoreCase("register"))
		{
			//전체 게시글 페이지
			model = new RegisterAction();
		}
		else if(cmd.equalsIgnoreCase("registerOk"))
		{
			model = new RegisterOkAction();
		}
		else if(cmd.equalsIgnoreCase("login"))
		{
			model = new LoginAction();
		}
		else if(cmd.equalsIgnoreCase("loginOk"))
		{
			model = new LoginOkAction();
		}

		viewPage = model.execute(req, resp);
		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//페이지 흐름 제어
		String cmd = req.getParameter("cmd");
		Action model = null;
		
		String viewPage = null;

		if(cmd==null || cmd.equalsIgnoreCase("register"))
		{
			//전체 게시글 페이지
			model = new RegisterAction();
		}
		else if(cmd.equalsIgnoreCase("registerOk"))
		{
			model = new RegisterOkAction();
		}
		else if(cmd.equalsIgnoreCase("login"))
		{
			model = new LoginAction();
		}
		else if(cmd.equalsIgnoreCase("loginOk"))
		{
			model = new LoginOkAction();
		}

		viewPage = model.execute(req, resp);
		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
}
