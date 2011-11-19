import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletContext;

public class getCode extends HttpServlet {
    
   
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/zip");
              
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/project2.zip");
        
        int read = 0;
        byte[] bytes = new byte[1024];
        
        OutputStream os;
        try {
            os = response.getOutputStream();
       
        
        while((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        os.close();
        
        } 
        catch (IOException ex) {}            

    }

    
}
