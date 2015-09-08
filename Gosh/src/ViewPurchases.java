

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Gcart;

/**
 * Servlet implementation class ViewPurchases
 */
@WebServlet("/ViewPurchases")
public class ViewPurchases extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPurchases() {
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
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String message = "";
		String username =(String) request.getSession().getAttribute("username");
		try{
			List<Gcart> cart = DBUtil.getPurchased(username);
			message += "<div class=\"container\">";
			message += "<table class=\"table table-bordered\"><thead><tr><th>Product Name</th><th>Price"
					+ "</th><th>Quantity</th><th>Return?</th></tr></thead><tbody>";
			for (Gcart prod : cart)
			{
				message += "<tr>";
				message += "<td>"
						+ prod.getProductname()+"</td><td>"+prod.getPrice()+ "</td>"
								+ "<td>"+prod.getQuantity()+ "</td><td><a href = \"ReturnItem?id="+prod.getId()+"&quantity="+prod.getQuantity()+"&pid="+prod.getProductid()+"\"><button type=\"button\" class=\"btn btn-info\">Return</button></a>" + "</td>";
				message += "</td></tr>";
			}
			message += "</tbody></table>";
			message += "</div>";
			
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/output1.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
