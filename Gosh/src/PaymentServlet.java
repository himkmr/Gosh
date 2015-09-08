
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

import model.DBUtil;
import model.Gcart;
import model.Gproduct;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//card information
		String uid = (String) request.getSession().getAttribute("username");
		double cardnum = Double.parseDouble(request.getParameter("c_num"));
		String carddate = request.getParameter("c_date");
		double cvv = Double.parseDouble(request.getParameter("c_code"));
		
		//billing info
		String b_address = request.getParameter("b_address");
		String b_city = request.getParameter("b_city");
		String b_state = request.getParameter("b_state");
		String b_zipcode = request.getParameter("b_zipcode");
		System.out.println(request.getParameter("ship_to_billing_address"));
		String s_address ="";
		String s_city ="";
		String s_state ="";
		String s_zipcode  ="";
	//shipping into
		if (request.getParameter("ship_to_billing_address")==null)
		{
		 s_address = request.getParameter("s_address");
		 s_city = request.getParameter("s_city");
		 s_state = request.getParameter("s_state");
		 s_zipcode = request.getParameter("s_zipcode");
		}
		else
		{
			 s_address = b_address;
			 s_city = b_city;
			 s_state =b_state;
			 s_zipcode = b_zipcode;
		}
		
		//database stuff
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Gpayment pay = new model.Gpayment();
		trans.begin();
		try {
			
			pay.setBAddress(b_address);
			pay.setBCity(b_city);
			pay.setBState(b_state);
			pay.setBZipcode(b_zipcode);
			
			pay.setSAddress(s_address);
			pay.setSCity(s_city);
			pay.setSState(s_state);
			pay.setSZipcode(s_zipcode);
			
			pay.setCNum(cardnum);
			pay.setCCode(cvv);
			pay.setCDate(carddate);
			
			pay.setPUsername(uid);
			em.persist(pay);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			e.printStackTrace();
		} 
		
	
	
		//****************
	/*	trans.begin();*/

		List<Gcart> cart = (List<Gcart>) request.getSession().getAttribute("cart");
		if(cart==null)
			System.out.println("cart is null");
		else
		{
			cart.get(0).getProductid();
			
		}
		
		try {

		for(Gcart loop: cart)
		{
				System.out.println("loop 1");
				
				loop.setBought(1);
				DBUtil.update(loop);
				
				int quan_dec = loop.getQuantity();
				int prodID = loop.getProductid();
				
				Gproduct gp = DBUtil.getProduct(prodID+"");
			
				gp.setIquantity(gp.getIquantity()-quan_dec);
				DBUtil.update(gp);
				
		}

			
			} catch (Exception e) {
				System.out.println("ERROR:" + e);
				e.printStackTrace();
				
			} 
		
		
		
		
		
		request.getSession().setAttribute("cart", null);
		
		
		
		
		
		
	//	DBUtil.update(uid);
		
		getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}