package enrique.garcia.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enrique.garcia.model.Activity;
import enrique.garcia.repository.ActividadesRepository;


@WebServlet("/Validation")
public class ValidationSerlvet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    ActividadesRepository repository = new ActividadesRepository();
	
    public ValidationSerlvet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doPost(request, response);
		Activity activity = getActivityFromRequest(request);
		if(repository.activityIsRealizable(activity)) {
			redirect(request, response, "/ok.jsp");
		}else {
			redirect(request, response, "/Fail.jsp");
		}
		
	}

}
