

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Gproduct;

/**
 * Servlet implementation class viewForSale
 */
@WebServlet("/viewForSale")
public class viewForSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewForSale() {
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
		request.getSession().setAttribute("username", "victoria");
		String username = (String) request.getSession().getAttribute("username");
		List<Gproduct> list = DBUtil.getProductList(username);
		String message ="";	
		message += "<div class=\"container\">";
		message += "<table class=\"table table-bordered\"><thead><tr><th>Product Name</th><th>Description</th>"
				+ "<th>Price</th><th>Quantity</th>"
				+ "<th>Picture</th><th>Shipping Cost</th><th>Availability</th><th>Edit?</th></tr></thead><tbody>";
		for (Gproduct prod : list) {
			message += "<tr>";
			message += "<td>";
			message += prod.getPname()+"</td><td>";
			message += prod.getDescription()+"</td><td>";
			message += prod.getPrice()+"</td><td>";
			message += prod.getIquantity()+"</td><td>";
			message += "<img src=\""+prod.getPicture()+"\" class=\"img-rounded\" alt=\"Cinque Terre\" width=\"304\" height=\"236\">"+"</td><td>";
			message += prod.getSCost()+"</td><td>";
			message += prod.getAvailable()+"</td><td>";
			message += "<form action=\"EditItem\"><input name=\"id\" type =\"hidden\" value="+prod.getId()+"><input type=\"submit\" value=\"Edit\"></form>";
			message += "</tr>";
		}
		message += "</tbody></table>";
		message += "</div>";
		message += "<a href= \"addSale.html\"> Add another Item</a>";
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
	}

}
