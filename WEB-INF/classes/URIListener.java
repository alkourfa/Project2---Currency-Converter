import javax.servlet.*;

public class URIListener implements ServletContextListener {

	public void contextInitialized (ServletContextEvent event){
		ServletContext sc = event.getServletContext();
		String link = sc.getInitParameter("myLink");
		myLink r = new myLink(link);
		sc.setAttribute("link",r);
	}
	
	public void contextDestroyed (ServletContextEvent event){
	
	}
}