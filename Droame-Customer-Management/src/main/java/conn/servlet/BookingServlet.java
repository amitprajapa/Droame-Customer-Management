package conn.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;

import conn.dao.BookingDAO;
import conn.entity.Booking;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int booking_id = Integer.parseInt(request.getParameter("booking_id"));
        String location = request.getParameter("location_id");
        String drone_shot = request.getParameter("drone_shot_id");
        String created_time = request.getParameter("created_time");
        
 
        Booking booking = new Booking(booking_id,location,drone_shot,created_time);
        BookingDAO dao=new BookingDAO(DBConnect.getConn());
        
        HttpSession session=request.getSession();
		
		
		boolean f=dao.addBookingDetails(booking);
		
		if(f)
		{
			session.setAttribute("succMg","Oders Details Submit Sucessfully..");
			response.sendRedirect("bookingForm.jsp");
			//System.out.println("Customer Details Submited...");
		}else {
			session.setAttribute("errorMg","something wrong on server..");
			response.sendRedirect("bookingForm.jsp");
			//System.out.println("something wrong on server");
		}
    }

}
