

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Gproduct;

/**
 * Servlet implementation class addForSale
 */
@WebServlet("/addForSale")
public class addForSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addForSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String pname = (String) request.getParameter("pname");
		double price = Double.parseDouble(request.getParameter("price"));
		String desc = (String) request.getParameter("description");
		int quantity  = Integer.parseInt(request.getParameter("quantity"));
		String avstring  = (String) request.getParameter("available");
		String pic = (String) request.getParameter("pic");
		double scost  = Double.parseDouble(request.getParameter("scost"));
		String username = (String)request.getSession().getAttribute("username");
		System.out.println(pic);
		System.out.println("Price:"+ price);
		
			
		if (request.getSession().getAttribute("username") == null
					|| request.getSession().getAttribute("username") == "") {
				String message = "Not Signed In!";
				request.setAttribute("message", message);
				response.setContentType("text/html");
				request.getServletContext().getRequestDispatcher("/output1.jsp")
						.forward(request, response);
			} else {
				Gproduct prod = new Gproduct();
				if (avstring.equalsIgnoreCase("yes"))
				{ prod.setAvailable(1); }
				else
				{ prod.setAvailable(0);}
				prod.setDescription(desc);
				prod.setIquantity(quantity);
				prod.setPicture(pic);
				prod.setPname(pname);
				prod.setSCost(scost);
				prod.setPusername(username);
				prod.setPrice(price);
				DBUtil.insert(prod);
				
				request.getServletContext().getRequestDispatcher("/viewForSale")
						.forward(request, response);
			}
	}

}
