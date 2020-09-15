package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.reserveDAO;
import vo.campSiteVo;
import vo.reserveVo;

public class reasultsAction implements Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String checkin_date = req.getParameter("checkin_date");
		String checkout_date = req.getParameter("checkout_date");
		String sleeps = req.getParameter("sleeps");
	
		if(checkin_date !=null && checkout_date!=null && sleeps!=null){
			int total_p = Integer.parseInt(sleeps);
			reserveDAO dao = new reserveDAO();
			reserveVo rvo = new reserveVo();
			rvo.setStdDate(checkin_date);
			rvo.setEndDate(checkout_date);
			rvo.setTotal_p(total_p);
			
			ArrayList<campSiteVo> list = dao.available(rvo);
			ArrayList<campSiteVo> listA = new ArrayList<campSiteVo>();
			ArrayList<campSiteVo> listB = new ArrayList<campSiteVo>();
			ArrayList<campSiteVo> listC = new ArrayList<campSiteVo>();
			for(campSiteVo vo : list){
				if(vo.getAreaCode().equals("A")){
					listA.add(vo);
				}else if(vo.getAreaCode().equals("B")){
					listB.add(vo);
				}else if(vo.getAreaCode().equals("C")){
					listC.add(vo);
				}
			}
			req.setAttribute("listA", listA);
			req.setAttribute("listB", listB);
			req.setAttribute("listC", listC);
			
			req.getSession().setAttribute("rvo", rvo);
			return "/camp/reasults.jsp";
		}else {
			return "/camp/search.jsp";
		}
	}
}
