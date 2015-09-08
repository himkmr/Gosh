
import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid = (String) request.getSession().getAttribute("username");
		
		int item_id = Integer.parseInt(request.getParameter("action"));
		List<Gcart> cartlist;
		System.out.println(item_id);
		if(request.getSession().getAttribute("cart")==null)
		{
			cartlist = new ArrayList<Gcart>();		
		}
		else
		{
			cartlist = (List<Gcart>) request.getSession().getAttribute("cart");
		
		}
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String q2 = "select p from Gproduct p where p.id = " +item_id;
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		TypedQuery<Gproduct> bq2 = em.createQuery(q2, Gproduct.class);
		List<Gproduct> list2 = bq2.getResultList();
	
		System.out.println("this is my array "+list2.get(0).getPname());
		System.out.println("this is my array "+list2.size());
		for(int i=0; i< list2.size(); i++) {
			Gcart obj = new Gcart();
			
			obj.setCusername(uid);
			obj.setProductid(item_id);
			obj.setProductname(list2.get(i).getPname());
			obj.setPrice(list2.get(i).getPrice());
			obj.setQuantity(quantity);
			obj.setBought(0);
			cartlist.add(obj);
			
		}
		
		request.getSession().setAttribute("cart", cartlist);
		
		getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request,  response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}