package fi.admin.omapizzeria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.PalauteDAO;
import fi.omapizzeria.admin.bean.Palaute;

import java.util.Date;
/**
 * Servlet implementation class PalauteServlet
 */
@WebServlet("/Palaute")
public class PalauteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalauteServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		

		
		
		response.sendRedirect("contact.jsp?sent");
		
	}

}
