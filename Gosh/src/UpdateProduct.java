

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Gproduct;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
		Gproduct prod = new Gproduct();
		prod.setAvailable(Integer.parseInt(request.getParameter("available")));
		prod.setDescription(request.getParameter("description"));
		prod.setId(request.getParameter("pid"));
		prod.setIquantity(Integer.parseInt(request.getParameter("quantity")));
		prod.setPicture(request.getParameter("picture"));
		prod.setPname(request.getParameter("pname"));
		prod.setPrice(Double.parseDouble(request.getParameter("price")));
		prod.setPusername((String) request.getSession().getAttribute("username"));
		prod.setSCost(Double.parseDouble(request.getParameter("scost")));
		DBUtil.update(prod);
	
		getServletContext().getRequestDispatcher("/viewForSale").forward(request, response);
		
	}

}
