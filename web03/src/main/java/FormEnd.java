

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("UTF-8");
		
		out.println("<html>");
		out.println("<head><title>받은 회원 정보값</title>");
		out.println("<body><ol>");
		
		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String values[] = req.getParameterValues(name);
			if(values != null) {
				for(int i=0; i<values.length; i++) {
					out.print("<li>"+name+" : "+values[i]);
				}
			}
		}
		out.println("</ol></body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
