package Subiect4_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Destinatii
 */
@WebServlet("/Destinatii")
public class Destinatii extends HttpServlet {
	
	Vector destinatii = new Vector();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destinatii() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if(request.getParameter("btnAdaugare")!=null)
		{
			String denumire = request.getParameter("denumire");
			String zi = request.getParameter("zi");
			String luna = request.getParameter("luna");
			String an = request.getParameter("an");

			Calendar data = Calendar.getInstance();
			data.set(Integer.parseInt(an), Integer.parseInt(luna), Integer.parseInt(zi));

			Destinatie d = new Destinatie (denumire,data);
			destinatii.addElement(d);

			out.println("<html><head><title>Destinatiile adaugate</title></head><body>");
			out.println("<form method='GET' action='Destinatii'");
			out.println("<h1 align='left'></h1>");
			out.println("<table align='left' width='50%' cellspacing='5' border='1'>");
			out.println("<tr><th align='center'>Denumire</th>");
			out.println("<th align='center'>Data vizitarii</th></tr>");

			for (int i=0; i<destinatii.size(); i++)
			{
				if(destinatii.elementAt(i) instanceof Destinatie)
				{
					Destinatie dest = (Destinatie)destinatii.elementAt(i);
					out.println("<tr><td align='left'>" + dest.getDestinatie() + "</td>");
					out.println("<td align='left'>" + dest.afisareData() + "</td></tr>");
				}
			}
			out.println("</table>");
			out.println("<p></table style='clear:both'><tr><td><input type='submit' value='Afisare ordonata' name='btnOrd'></td></tr></table></p>");
			//out.println("</form>");
			
		}
		if (request.getParameter("btnOrd")!=null)
		{
			Collections.sort(destinatii, new ComparaDestinatie());
			
			out.println("<table align='left' width='50%' cellspacing='5' border='1'>");
			out.println("<tr><th align='center'>Denumire</th>");
			out.println("<th align='center'>Data vizitarii</th></tr>");

			for (int i=0; i<destinatii.size(); i++)
			{
				if(destinatii.elementAt(i) instanceof Destinatie)
				{
					Destinatie dest = (Destinatie)destinatii.elementAt(i);
					out.println("<tr><td align='left'>" + dest.getDestinatie() + "</td>");
					out.println("<td align='left'>" + dest.afisareData() + "</td></tr>");
				}
			}
			out.println("</table>");
		}
		out.println("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	
	}

}
