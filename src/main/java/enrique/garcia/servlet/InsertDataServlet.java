package enrique.garcia.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enrique.garcia.model.Activity;
import enrique.garcia.repository.ActividadesRepository;

public class InsertDataServlet extends BaseServlet{
	
			ActividadesRepository repository = new ActividadesRepository();
			
			@Override
   			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//super.doPost(req, resp);
			Activity activity = getActivityFromRequest(req);
			repository.insert(activity);
			redirect(req, resp, "/FeedBack.jsp");
			}
}
