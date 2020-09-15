package boardAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReplyDAO;
import dao.ReviewDAO;
import vo.ReplyVO;
import vo.ReviewVO;

public class DetailAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		String no = req.getParameter("rno");
		
 		if(no!=null)
 		{
 			///////////////////////게시판 /////////////////////////////////
 			
			int rno = Integer.parseInt(no);
			
			ReviewDAO dao = new ReviewDAO();
			
			//조회수 증가 메소드 추가
			dao.raiseHits(rno);
			// 댓글개수 파악 메소드 추가
			dao.updateReplyCount(rno);
			
			ReviewVO vo = dao.getData(rno);
			
			req.setAttribute("vo", vo);
			////////////////////////////////////////////////////////////////////////////
			//////////////////////댓글 //////////////////////////////////////////////////
			
			ReplyDAO rdao = new ReplyDAO();
			
			ArrayList<ReplyVO> list = rdao.getAllReply(rno);
			
			req.setAttribute("list", list);
			
			
			return "/board/detail.jsp";
			
 		}
 		else
 		{
 			return "/board/list.jsp";
 		}

	}

}
