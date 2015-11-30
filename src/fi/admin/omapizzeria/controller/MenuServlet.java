package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PizzaDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.Ostoskori;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//PizzaDAO pDao = new PizzaDAO();
		//List<Pizza> pizzat = pDao.haePizzat();	
		
		TayteDAO tDao = new TayteDAO();
		List<Pizza> pizzat = tDao.haePizzat();
		
		
		LinkedList<Ostoskori> ostoskoriArray = new LinkedList<Ostoskori>();
		
		
		request.setAttribute("pizzat", pizzat);
		request.setAttribute("ostoskoritaulukko",ostoskoriArray);
		
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
