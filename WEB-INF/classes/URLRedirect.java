import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class URLRedirect extends HttpServlet{

	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws IOException,ServletException {
		
		myLink link = (myLink)getServletContext().getAttribute("link");
		response.sendRedirect(link.getLink());
	}
}