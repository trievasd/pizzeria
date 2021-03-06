package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import fi.omapizzeria.admin.bean.TilausRivi;

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
		
		double hintasumma = 0;
		if (request.getSession().getAttribute("ostoskoritaulukko")==null)
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = new LinkedList<OstoskoriPizza>();;
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			request.getRequestDispatcher("tilaus.jsp").forward(request, response);
			
			System.out.println("Ostoskori on tyhj�");
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
	
				hintasumma = hintasumma + (ostoskoriItem.getRivihinta());
			}
			request.setAttribute("summa",hintasumma);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double hintasumma = 0;
		
		LinkedList<OstoskoriPizza> ostoskoritaulukko = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
		Iterator it = ostoskoritaulukko.iterator();
		
		while (it.hasNext()) {
			OstoskoriPizza ostoskoriItem = (OstoskoriPizza) it.next();
			hintasumma = hintasumma + (ostoskoriItem.getRivihinta());
		}


	
		
		String tetun = request.getParameter("tetunimi");
		String tsukun = request.getParameter("tsukunimi");
		String tos = request.getParameter("tosoite");
		String tpostinro = request.getParameter("tpostinro");
		String tpostitmp = request.getParameter("tpostitmp");
		String tpuh = request.getParameter("contactpuh");
		Date nykyhetki = new Date();

		
		Tilaus2 t = new Tilaus2(tetun, tsukun, tpuh, hintasumma, tos, tpostinro, tpostitmp, nykyhetki);

		try {
			TilausDAO tilDao = new TilausDAO();
			tilDao.lisaa(t);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		
		try {
			LinkedList<OstoskoriPizza> ostoskoritaulukko2 = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
			Iterator it2 = ostoskoritaulukko2.iterator();
			
			TilausDAO tilDao2 = new TilausDAO();
			int tilaus_id = tilDao2.haeTilaus(nykyhetki);

			
			while (it2.hasNext()) {
				int tuo_id = 0;
				OstoskoriPizza ostoskoriItem = (OstoskoriPizza) it2.next();
	
			
				int maara = 1;
				tuo_id = ostoskoriItem.getTuote_id();
				double tuo_hinta = ostoskoriItem.getRivihinta();
				double hintarivi = maara * tuo_hinta;
				boolean oregano = false;
				boolean valkosipuli = false;
				
				TilausRivi til = new TilausRivi(maara, tilaus_id, tuo_id, hintarivi, oregano, valkosipuli);
				tilDao2.lisaaRivi(til);
			}
		
			
		} catch (DAOPoikkeus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		request.getSession().invalidate();
		response.sendRedirect("etusivu?sent=true");
	}

}
