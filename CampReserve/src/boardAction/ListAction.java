package boardAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.ReviewDAO;
import vo.ReviewVO;

public class ListAction implements Action
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		//페이징 처리
		
		//현재 페이지 (currentPage) 얻어오기
		String cp = req.getParameter("cp");

		int currentPage = 0;
		
		if(cp!=null)
		{
			currentPage = Integer.parseInt(cp);
		}
		else
		{
			currentPage = 1;
		}
		
		ReviewDAO dao = new ReviewDAO();
		// 총 게시글 수
		int totalCount = dao.getTotalCount();
		
		// 한 페이지당 레코드 수 : 10
		int recordByPage = 12;
		
		// 총 페이지 수
		int totalPage = (totalCount%recordByPage == 0)?totalCount/recordByPage:totalCount/recordByPage+1;
					
		//현재 페이지 - 레코드 시작번호
		int startNo = (currentPage-1)*recordByPage+1;
		
		//현재 페이지 - 레코드 끝 번호
		int endNo = currentPage*recordByPage;
		
		String order = req.getParameter("orderPage");
		int pageOrder = 0;
		if(order != null) 
		{
			pageOrder = Integer.parseInt(order);
		}
		
		// DBMS에 있는 게시글 데이터 얻기
		ArrayList<ReviewVO> list = dao.getAllData(startNo, endNo, pageOrder);
		
		
		// 요청 객체에 set
		req.setAttribute("list", list);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("orderPage", pageOrder);
		

		return "/board/list.jsp";
	}
	
}
