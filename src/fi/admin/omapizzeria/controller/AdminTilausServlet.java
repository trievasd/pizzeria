package fi.admin.omapizzeria.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminTilausDAO;
import dao.OstoskoriDAO;
import fi.omapizzeria.admin.bean.AdminTilausRivi;
import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.Tilaus2;

/**
 * Servlet implementation class AdminTilausServlet
 */
@WebServlet("/AdminTilaus")
public class AdminTilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTilausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/AdminTilaus.jsp");
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


		AdminTilausDAO aDao = new AdminTilausDAO();
		List<Tilaus2> tilaukset = aDao.haeTilaukset();
		request.setAttribute("tilaukset", tilaukset);
		request.getRequestDispatcher("AdminTilaus.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tilaus_idstring = request.getParameter("tilaus_id");		
		int tilaus_id = Integer.parseInt(tilaus_idstring);
		
		
		AdminTilausDAO adDao = new AdminTilausDAO();
		List<AdminTilausRivi> tilausrivit = adDao.find(tilaus_id);

		System.out.println("Rivejä" + tilausrivit.toString());
		
		request.setAttribute("tilausrivit", tilausrivit);
		jsp.forward(request,response);
		
		
	}

}
