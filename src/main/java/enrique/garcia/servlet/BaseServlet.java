package enrique.garcia.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enrique.garcia.model.Activity;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Activity getActivityFromRequest(HttpServletRequest req) {
		Activity activity = new Activity();
		activity.setName(req.getParameter("name"));
		//Así ya funcionaría activity.setGauging((Integer.parseInt(req.getParameter("gauging"))));
		Optional<String> optional = Optional.ofNullable(req.getParameter("gauging"));
		activity.setGauging(Integer.parseInt(optional.orElse("0")));
		System.out.println(optional);
		System.out.println(activity.getName());
		return activity;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}