
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



import model.*;

import model.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in get");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		Double credit = 0.0;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Guser user = new model.Guser();
		String message = "";
		HttpSession session = request.getSession();

		
//			acc.setUsername(password);
			session.setAttribute("username", username);
			String q="select g from Guser g where g.username ='"+username+"'";
			System.out.println(q);
			TypedQuery<Guser>aq =em.createQuery(q,Guser.class);
			System.out.println(aq);
			List<Guser> list1=aq.getResultList();
			//System.out.println("query reult:"+aq.getResultList());
			/*for(Guser temp: list1)
				credit = temp.getCredit().doubleValue();
			session.setAttribute("credit", credit);*/
		/*	System.out.println("The credit is "+credit);*/
			if (list1 == null || list1.isEmpty())
			{
				message = "Incorrect username or password";
				response.setContentType("text/html");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
			else	
				{
				/*ArrayList<CartObj> myArray = new ArrayList<CartObj>();*/
				String q2 = "select c from Gcart c where c.cusername ='" +username+"'";
				TypedQuery<Gcart> bq2 = em.createQuery(q2, Gcart.class);
				List<Gcart> cartlist = bq2.getResultList();
				session.setAttribute("cart", cartlist);
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			
		
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}