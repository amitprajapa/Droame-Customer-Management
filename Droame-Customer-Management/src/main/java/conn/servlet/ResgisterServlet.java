package conn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;

import conn.entity.Customer;
import conn.dao.CustomerDAO;
@WebServlet("/register")
public class ResgisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String number=req.getParameter("number");
		String address=req.getParameter("address");
		
		Customer customer=new Customer(name,email,number,address);
		
		CustomerDAO dao=new CustomerDAO(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		
		boolean f=dao.addCustomer(customer);
		
		if(f)
		{
			session.setAttribute("succMg","Customer Details Submit Sucessfully..");
			resp.sendRedirect("add_customer.jsp");
			//System.out.println("Customer Details Submited...");
		}else {
			session.setAttribute("errorMg","something wrong on server..");
			resp.sendRedirect("add_customer.jsp");
			//System.out.println("something wrong on server");
		}
	}

}
