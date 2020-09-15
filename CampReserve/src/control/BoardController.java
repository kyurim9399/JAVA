package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import boardAction.DeleteAction;
import boardAction.DeleteReplyAction;
import boardAction.DetailAction;
import boardAction.InsertFormAction;
import boardAction.InsertReplyAction;
import boardAction.InsertRereplyAction;
import boardAction.InsertRereplyOkAction;
import boardAction.ListAction;
import boardAction.LogoutAction;
import boardAction.ModifyFormAction;
import boardAction.ModifyReplyAction;
import boardAction.ModifyReplyOkAction;
import boardAction.ModifyWriteAction;
import boardAction.WriteAction;

@WebServlet("/board.do")
public class BoardController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//페이지 흐름 제어
		String cmd = req.getParameter("cmd");
		Action model = null;
		
		String viewPage = null;
		
		if(cmd==null || cmd.equalsIgnoreCase("list"))
		{
			//전체 게시글 페이지
			model = new ListAction();
		}
		else if(cmd.equalsIgnoreCase("insertForm"))
		{
			//글 작성 form 페이지
			model = new InsertFormAction();
		}
		else if(cmd.equalsIgnoreCase("insert"))
		{
			//글 작성 페이지
			model = new WriteAction();
		}
		else if(cmd.equalsIgnoreCase("detail"))
		{
			//글 작성 페이지
			model = new DetailAction();
		}
		else if(cmd.equalsIgnoreCase("modify"))
		{
			//게시글 수정 form 보여주기
			model = new ModifyFormAction();
		}
		else if(cmd.equalsIgnoreCase("modifyOk"))
		{
			//게시글 수정 기능 수행
			model = new ModifyWriteAction();
		}
		else if(cmd.equalsIgnoreCase("deleteOk"))
		{
			//게시글 삭제 기능 수행
			model = new DeleteAction();
		}
		else if(cmd.equalsIgnoreCase("replyOk"))
		{
			model = new InsertReplyAction();
		}
		else if(cmd.equalsIgnoreCase("rereply"))
		{
			model = new InsertRereplyAction();
		}
		else if(cmd.equalsIgnoreCase("rereplyOk"))
		{
			model = new InsertRereplyOkAction();
		}
		else if(cmd.equalsIgnoreCase("modifyReply"))
		{
			model = new ModifyReplyAction();
		}
		else if(cmd.equalsIgnoreCase("modifyReplyOk"))
		{
			model = new ModifyReplyOkAction();
		}
		else if(cmd.equalsIgnoreCase("deleteReply"))
		{
			model = new DeleteReplyAction();
		}
		else if(cmd.equalsIgnoreCase("logout"))
		{
			model = new LogoutAction();
		}
		
		viewPage = model.execute(req, resp);
		
		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
