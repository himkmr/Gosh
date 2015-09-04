

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Gproduct;
import model.Guser;

/**
 * Servlet implementation class ReturnItem
 */
@WebServlet("/ReturnItem")
public class ReturnItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnItem() {
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
		String username = (String)request.getSession().getAttribute("username");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Gproduct p = DBUtil.getProduct(pid);
		int q = p.getIquantity();
		double price = p.getPrice();
		int q_in_cart = Integer.parseInt(request.getParameter("quantity"));
		int new_q = q + q_in_cart;
		p.setIquantity(new_q);
		DBUtil.update(p);
		DBUtil.delete(pid);
		Guser u = DBUtil.getUser(username);
		u.setBalance((u.getBalance())+price);
		DBUtil.update(u);

		getServletContext().getRequestDispatcher("/ViewPurchases").forward(request, response);
	}

}
