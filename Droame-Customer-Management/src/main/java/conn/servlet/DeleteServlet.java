package conn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;

import conn.dao.CustomerDAO;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CustomerDAO dao=new CustomerDAO(DBConnect.getConn());
		boolean f=dao.deleteCustomer(id);
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("succMg","Customer Details Detete Sucessfully..");
			resp.sendRedirect("index.jsp");
			//System.out.println("Customer Details Submited...");
		}else {
			session.setAttribute("errorMg","something wrong on server..");
			resp.sendRedirect("index.jsp");
			//System.out.println("something wrong on server");
		}
	}
	

}
