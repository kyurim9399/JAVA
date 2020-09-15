package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.confirmAction;
import action.confirmOkAction;
import action.payAction;
import action.reasultsAction;
import action.searchAction;
import action.selectAction;

@WebServlet("/camp.do")
public class CampController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		Action model = null;	
		String viewPage = null;
		
		if(cmd == null || cmd.equalsIgnoreCase("search")) {
			model = new searchAction();
		}else if(cmd.equalsIgnoreCase("search")) {
			model = new searchAction();
		}else if(cmd.equalsIgnoreCase("reasults")) {
			model = new reasultsAction();
		}else if(cmd.equalsIgnoreCase("select")) {
			model = new selectAction();
		}else if(cmd.equalsIgnoreCase("pay")) {
			model = new payAction();
		}else if(cmd.equalsIgnoreCase("confirm")) {
			model = new confirmAction();
		}else if(cmd.equalsIgnoreCase("confirmOk")) {
			model = new confirmOkAction();
		}
		
		viewPage = model.execute(req, resp);
		
		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
