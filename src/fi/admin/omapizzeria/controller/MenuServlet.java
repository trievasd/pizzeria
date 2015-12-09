package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OstoskoriDAO;
import dao.PizzaDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.OstoskoriPizza;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/menu.jsp");
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
		
		
		//PizzaDAO pDao = new PizzaDAO();
		//List<Pizza> pizzat = pDao.haePizzat();	
		
		TayteDAO tDao = new TayteDAO();
		List<Pizza> pizzat = tDao.haePizzat();
		
		
		//if(request.getSession().{
		
		if (request.getSession().getAttribute("ostoskoritaulukko")==null)
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = new LinkedList<OstoskoriPizza>();
			request.setAttribute("pizzat", pizzat);
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			
			System.out.println("Ostoskori on tyhjä");
		}
		else
		{
			LinkedList<OstoskoriPizza> ostoskoritaulukko = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
			request.setAttribute("pizzat", pizzat);
			request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
			
			request.getRequestDispatcher("menu.jsp").forward(request, response);
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

		TayteDAO tDao = new TayteDAO();
		List<Pizza> pizzat = tDao.haePizzat();
		
		LinkedList<OstoskoriPizza> ostoskoritaulukko = (LinkedList<OstoskoriPizza>) request.getSession().getAttribute("ostoskoritaulukko");
		for (int i = 0; i < ostoskoritaulukko.size(); i++){
			System.out.println("Jotain: " + ostoskoritaulukko.get(i).getTuote_id());
		}
		
				
		OstoskoriPizza ostoskoripizza = new OstoskoriPizza();
		String tuoteidString = request.getParameter("tuoteid");
		
		int tuoteid = Integer.parseInt(tuoteidString);

		
		OstoskoriDAO oDao = new OstoskoriDAO();
		Pizza pizza = oDao.find(tuoteid);
		System.out.println("Tuotteita...." + pizza.toString());
		
		//List<Pizza> ostoskoripizza = oDao.find(int tuoteid);
		
		ostoskoripizza.setTuote_id(new Integer(tuoteidString));
		ostoskoripizza.setTuote_nimi(pizza.getNimi());
		ostoskoripizza.setRivihinta(pizza.getHinta());
		ostoskoritaulukko.add(ostoskoripizza);

		request.setAttribute("pizzat", pizzat);
		request.setAttribute("ostoskoritaulukko",ostoskoritaulukko);
		jsp.forward(request,response);
	}

}
