package pizzeria.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Pizza;
import dao.PizzaDAO;






@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ControllerServlet() {
    	 super();
    	
    	 
    	
    	 

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		List<Pizza> pizzalista = new ArrayList<Pizza>();
		pizzalista.add(new Pizza(1, "Margarita", 7.90));
		pizzalista.add(new Pizza(2, "Frutti di Mare", 9.90));
		pizzalista.add(new Pizza(3, "Speciale", 9.90));
		
		Date aloitusaika = (Date)request.getSession().getAttribute("aloitusaika");
		
		PizzaDAO pDao = new PizzaDAO();
	List<Pizza> pizzat = pDao.haeKaikki();	
	
		if (aloitusaika == null) {
			aloitusaika = new Date();
			request.getSession().setAttribute("aloitusaika", aloitusaika);
		}
		
		request.setAttribute("pizzalista", pizzalista);
		request.setAttribute("pizzat", pizzat);
		
		request.getRequestDispatcher("henkilot.jsp").forward(request, response);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
	}
	

		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter wout = response.getWriter();
		
	
		String nnimi = request.getParameter("nimi");
		String hhinta = request.getParameter("hinta");
		double dhinta = 0;
		
		
		
		
		try {
			dhinta = Double.parseDouble(hhinta);
			
			Pizza test1 = new Pizza(4,nnimi,dhinta);
			System.out.println(test1.toString());

		}
		catch(NumberFormatException e){
			System.out.println("ERROR");
			
			
		}
		response.sendRedirect("controller?added=true");
			
			
			
			    
			
			
		}
		

		
	
	
}
	


