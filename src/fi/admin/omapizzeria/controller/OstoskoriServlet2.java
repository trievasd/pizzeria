package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Ostoskori;

/**
 * Servlet implementation class OstoskoriServlet2
 */
@WebServlet("/OstoskoriServlet2")
public class OstoskoriServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OstoskoriServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/menu2.jsp");
		try {
			Class.forName("org.mariadb.jdbc.Driver");			
		}
		catch (ClassNotFoundException e)
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LinkedList<Ostoskori> ostoskoritaulukko = (LinkedList<Ostoskori>) request.getSession().getAttribute("ostoskoritaulukko");
		for (int i = 0; i < ostoskoritaulukko.size(); i++){
			System.out.println("Jotain: " + ostoskoritaulukko.get(i).getTuote_id());
		}
		
//		Ostoskori ostoskori = new Ostoskori();
//		String tuoteidString = request.getParameter("tuoteid");
//		ostoskori.setTuote_id(new Integer(tuoteidString));
//		ostoskoritaulukko.add(ostoskori);
//
//		request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
//		jsp.forward(request,response);
	}

}
