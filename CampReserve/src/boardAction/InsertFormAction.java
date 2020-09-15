package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class InsertFormAction implements Action 
{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
	{
		
		return "./board/write.jsp";
	}

}
