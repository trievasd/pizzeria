package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.TilausDAO;
import fi.omapizzeria.admin.bean.OstoskoriPizza;
import fi.omapizzeria.admin.bean.Tilaus;
import fi.omapizzeria.admin.bean.Tilaus2;

/**
 * Servlet implementation class TilausServlet
 */
@WebServlet("/Tilaus")
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TilausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/tilaus.jsp");
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("ostoskoritaulukko")==null)
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = new LinkedList<OstoskoriPizza>();;
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			request.getRequestDispatcher("tilaus.jsp").forward(request, response);
			
			System.out.println("Ostoskori on tyhjä");
		}
		else
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			
			request.getRequestDispatcher("tilaus.jsp").forward(request, response);
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
	
		System.out.println(request.getParameter("tetunimi"));
		System.out.println(request.getParameter("tsukunimi"));
		System.out.println(request.getParameter("tosoite"));
		System.out.println(request.getParameter("tpostinro"));
		System.out.println(request.getParameter("tpostitmp"));
		System.out.println(request.getParameter("contactpuh"));
		
		String tetun = request.getParameter("tetunimi");
		String tsukun = request.getParameter("tsukunimi");
		String tos = request.getParameter("tosoite");
		String tpostinro = request.getParameter("tpostinro");
		String tpostitmp = request.getParameter("tpostitmp");
		String tpuh = request.getParameter("contactpuh");
		Date nykyhetki = new Date();
		System.out.println(tetun);
		
		Tilaus2 t = new Tilaus2(tetun, tsukun, tpuh, 0, tos, tpostinro, tpostitmp, nykyhetki);
		System.out.println("tässä jotain" + t);
		try {
			TilausDAO tilDao = new TilausDAO();
			tilDao.lisaa(t);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("etusivu?sent=true");
	}

}
