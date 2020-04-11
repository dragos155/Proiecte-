package problema4_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	Vector<Statiune> statiuni = new Vector<Statiune>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><head><title></title><body>");
		out.println("<form method ='POST' action='http://localhost:8080/Problema4_2/Main'>");
		out.println("<p>Nume statiune:<input type='text' name='nume_statiune'></p>");
		out.println("<p>Tara in care se afla statiunea:<input type='text' name='tara_statiune'></p>");
		out.println("<p>Numar partii:<input type='text' name='nr_partii'></p>");
		out.println("<p><input type='submit' value ='Trimite' ></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String numes=request.getParameter("nume_statiune");
		String numet=request.getParameter("tara_statiune");
		System.out.println(numet);
		String nrp=request.getParameter("nr_partii");
		Integer x=Integer.parseInt(nrp);
		Statiune s = new Statiune (numes,numet,x);
		statiuni.addElement(s);
		
		
		out.println("<html><head><title>Destinatiile adaugate</title></head><body>");
		out.println("<h1 align='left'></h1>");
		out.println("<table align='left' width='50%' cellspacing='5' border='1'>");
		out.println("<tr><th align='center'>Nume statiune</th>");
		out.println("<th align='center'>Nume tara</th>");
		out.println("<th align='center'>Numar partii</th></tr>");
		
		for(Statiune y : statiuni)
		{
			out.println("<tr><td align='left'>" + y.getNume_statiune() + "</td>");
			out.println("<td align='left'>" + y.getNume_tara() + "</td>");
			out.println("<td align='left'>" + y.getNumar_partii() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</form></body></html>");
	}

}
