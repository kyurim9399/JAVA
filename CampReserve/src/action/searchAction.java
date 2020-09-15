package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.reserveDAO;
import vo.ProVO;
import vo.campSiteVo;
import vo.reserveVo;

public class searchAction implements Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "/camp/search.jsp";
	}
}
