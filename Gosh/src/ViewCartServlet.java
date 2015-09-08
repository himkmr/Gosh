
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.*;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true); 
		String uid = (String) session.getAttribute("username");
		System.out.println("the session userid is "+uid);
		String message = "";
		double total = 0;
		double shipping = 0;
		double sum = 0;
		String f_amount = "";
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
	
			if(request.getSession().getAttribute("cart")==null)
			{
				message = "<thead><tr><th>"+uid+" Cart</th></tr></thead>";
			//	CartObj myCart = new CartObj();
				//smyArray = new ArrayList<CartObj>();
				String q = "select c from Gcart c where c.cusername ='" +uid+"' and c.bought=0";
				System.out.println(q);
				TypedQuery<Gcart> bq = em.createQuery(q, Gcart.class);
				List<Gcart> list = bq.getResultList();
				
				 
				
				for (Gcart temp : list) {
					message += "<tr><td>Item: "+temp.getProductname()+"</td></tr>\n";
					message += "<tr><td>Price: "+temp.getPrice()+"</td></tr>\n";
					message += "<tr><td>Quantity: "+temp.getQuantity()+"</td></tr>\n";
					total = temp.getPrice()*temp.getQuantity();
					message += "<tr><td>Item total: "+total+"</td></tr>\n";
					
					// shipping cost get from
					String sql = "select p from Gproduct p where p.pname='" +temp.getProductname() + "'";
					TypedQuery<Gproduct> prodq = em.createQuery(sql, Gproduct.class);
					List<Gproduct> plist = prodq.getResultList();
					
					for(Gproduct ptemp : plist){
						shipping = ptemp.getSCost();
					}
					
					total = total+ shipping;
					
					message += "<tr><td>Item shipping: "+shipping+"</td></tr>\n";
					message += "<tr><td>Order total: "+total+"</td></tr>\n";
					sum += total;
				}
				
					message += "<tr><td>Total due is:  " +sum+ "</td></tr>\n";	
				
		
			}
			else
			{
				List<Gcart> cart =  (List<Gcart>) request.getSession().getAttribute("cart");
				message = "<thead><tr><th>You're Cart</th></tr></thead>";
				
				message = "<tr>" 
						+"<th>" + "Product Name" + "</th><br>"
						+"<th>" + "Price" + "</th><br>"
						+"<th>" + "Quantity" + "</th><br>"
						+"<th>" + "total price" + "</th><br>"
						+ "</tr>"
     			;
				for(Gcart loop: cart)
				{
					
					message += "<tr><td>Item: "+loop.getProductname()+"</td>";
					message += "<td>Price: "+loop.getPrice()+"</td>";
					message += "<td>Quantity: "+loop.getQuantity()+"</td>";
					total = loop.getPrice()*loop.getQuantity();
					message += "<td>Item total: "+total+"</td>";
					
					
					// shipping cost get from
					String sql = "select p from Gproduct p where p.pname='" +loop.getProductname() + "'";
					TypedQuery<Gproduct> prodq = em.createQuery(sql, Gproduct.class);
					List<Gproduct> plist = prodq.getResultList();
					System.out.println(sql);
					for(Gproduct ptemp : plist){
						shipping = ptemp.getSCost();
					}
					
					total = total + shipping;
					
					message += "<td>Item shipping: "+shipping+"</td>";
					message += "<td>Order total: "+total+"</td></tr>\n";
					sum += total;
				}
	
					message += "<tr><td>Total due is:  " +sum+ "</td></tr>\n";
				

			}
			
		request.setAttribute("message", message);
		response.setContentType("text/html");
	      getServletContext()
	      .getRequestDispatcher("/output.jsp")
	      .forward(request,  response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}