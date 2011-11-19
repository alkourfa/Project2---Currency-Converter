import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;

public class currencyConverter extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<title>International Currency Converter</title>" + "<body bgcolor=FFFFFF>");
		out.println("<h2>Currency Converter</h2>");
		String poso = request.getParameter("poso");
               
                
		if(poso == null){
			out.println("Please Insert Amount");
		}
		try{  
			Float.parseFloat(poso);
		}catch(NumberFormatException nfe){  
			out.println("Please Insert A Valid Amount");
			out.close();
		}  
		String CUR1 = request.getParameter("CURRENCY1");
		String CUR2 = request.getParameter("CURRENCY2");
		String path = "http://www.google.com/ig/calculator?hl=en&q="+poso+CUR1+"=?"+CUR2;
		try {
			URL convert = new URL(path);
			BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
			String answer = in.readLine();
			in.close();
			StringTokenizer st = new StringTokenizer(answer,"\"");
			st.nextToken();
			out.print(st.nextToken()+"=");
			st.nextToken();
                        out.print(st.nextToken());
                        
		}
		catch (IOException ioe) {
			System.exit(1);
		}
		out.close();
	}
}

