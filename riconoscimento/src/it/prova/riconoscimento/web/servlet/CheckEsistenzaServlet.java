package it.prova.riconoscimento.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.riconoscimento.model.Persona;

/**
 * Servlet implementation class CheckEsistenzaServlet
 */
@WebServlet("/CheckEsistenzaServlet")
public class CheckEsistenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEsistenzaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeParameter=request.getParameter("nomeInput");
		String cognomeParameter=request.getParameter("cognomeInput");

		RequestDispatcher rd = null;
		if (nomeParameter != null && !nomeParameter.isEmpty() && nomeParameter.equalsIgnoreCase("Enrico")
				&& cognomeParameter != null && !cognomeParameter.isEmpty() && cognomeParameter.equalsIgnoreCase("Cristofanilli") ) {
			request.setAttribute("persona_attribute", new Persona(nomeParameter,cognomeParameter));
			rd = request.getRequestDispatcher("rispostaGiusta.jsp");
		} else {
			rd = request.getRequestDispatcher("rispostaErrata.jsp");
		}
		rd.forward(request, response);
		
		

	}

}
