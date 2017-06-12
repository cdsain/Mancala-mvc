package nl.sogyo.mancalaWebApp;

import nl.sogyo.mancala.backend.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MancalaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public MancalaServlet() {
		
	}
	
	public void showPage(HttpServletRequest request, HttpServletResponse response, Mancala mancala) 
			throws IOException, ServletException {
		MancalaBean mb = new MancalaBean(mancala.getPlayersTurn()+1, mancala.getStonesAtBoard(), mancala, mancala.getWinner());
		request.setAttribute("currentState", mb);
		RequestDispatcher rd = request.getRequestDispatcher("currentstate.jsp");
		rd.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		if (session.getAttribute("MancalaBean") == null) {
			session.setAttribute("MancalaBean", new MancalaBean(new Mancala()));
		}
		Mancala mancala = ((MancalaBean) session.getAttribute("MancalaBean")).getMancala();
		showPage(request,response,mancala);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		MancalaBean mb = ((MancalaBean)session.getAttribute("MancalaBean"));
		if(mb == null){
			doGet(request, response);
		}
		Mancala mancala = mb.getMancala();
		BufferedReader read = request.getReader();
		try {
			String line = read.readLine();
			String split = line.split("=")[0];
			Integer location = Integer.parseInt(split);
			mancala.doMove(location - 7 * mancala.getPlayersTurn() + 1);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		showPage(request, response,mancala);
	}
	
}
