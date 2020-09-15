package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class LoginAction implements Action 
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		return "./member/login.jsp";
	}

}
