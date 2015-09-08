

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import model.DBUtil;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
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
		String message = "";
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		if(!uid.equals("admin"))
		{
		
		//****************
		trans.begin();

		try {
			String q="delete from Gcart c where c.cusername ='"+uid+"'";
			System.out.println(q);
			em.createQuery(q).executeUpdate();
			trans.commit();
					
		}
	 catch (Exception e) {
				System.out.println("ERROR:" + e);
				e.printStackTrace();
				
			} 
		//**********/
		List<Gcart> cart = (List<Gcart>) session.getAttribute("cart");
		message = "<thead><tr><th>You're Cart</th></tr></thead>";
		if(cart!=null)
		{
		try {
			trans.begin();
			
		for(Gcart loop: cart)
		{
			model.Gcart newcart = new model.Gcart();
		
				newcart.setCusername(uid);
				System.out.println(uid);
				newcart.setProductname(loop.getProductname());
				System.out.println(loop.getProductname());
				
				newcart.setPrice(loop.getPrice());
				
				newcart.setQuantity(loop.getQuantity());
				
				// pid cost get from
				String sql = "select p from Gproduct p where p.pname='" +loop.getProductname() + "'";
				TypedQuery<Gproduct> prodq = em.createQuery(sql, Gproduct.class);
				List<Gproduct> plist = prodq.getResultList();
				
				String pid ="";
				for(Gproduct ptemp : plist){
					pid = ptemp.getId();
				}
				
				newcart.setProductid(Integer.parseInt(pid));
				newcart.setBought(loop.getBought());
				em.persist(newcart);

		}
			trans.commit();
			} catch (Exception e) {
				System.out.println("ERROR:" + e);
				e.printStackTrace();
				
			} 
		}
		}
		session.setAttribute("username", null);
		session.setAttribute("cart", null);
			
	getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}