package fi.admin.omapizzeria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.PalauteDAO;
import fi.omapizzeria.admin.bean.OstoskoriPizza;
import fi.omapizzeria.admin.bean.Palaute;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Servlet implementation class PalauteServlet
 */
@WebServlet("/Palaute")
public class PalauteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalauteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/index.jsp");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("ostoskoritaulukko")==null)
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = new LinkedList<OstoskoriPizza>();;
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			request.getRequestDispatcher("contact.jsp").forward(request, response);
			
			System.out.println("Ostoskori on tyhjä");
		}
		else
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			
			request.getRequestDispatcher("contact.jsp").forward(request, response);
			System.out.println("Ostoskorissa on tuotteita");
			Iterator it = ostoskoritaulukko.iterator();
			while (it.hasNext()) {
				OstoskoriPizza ostoskoriItem = (OstoskoriPizza) it.next();
				System.out.println(ostoskoriItem.getTuote_id());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pnimi = request.getParameter("contactnimi");
		String pemail = request.getParameter("contactemail");
		String ppuh = request.getParameter("contactpuh");
		String pviesti = request.getParameter("palautetext");
		Date nykyhetki = new Date();
		
		Palaute p = new Palaute(pnimi, pemail, ppuh, pviesti, nykyhetki);
		
		try {
			PalauteDAO paDao = new PalauteDAO();
			paDao.lisaa(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		

		
		
		response.sendRedirect("Palaute?sent=true");
		
	}

}
