package it.prova.web.serlvlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//questa annotazione dice che la root del progetto parte da qui ovvero è la prima servlet lnciata
//quando chiamo sull'url http://localhost:8080/ProvaFilter/

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// questa servlet risulta utile quando ho qualcosa (una lista, un oggetto) che
		// va preparato prima di mostrare la pagina che segue
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
