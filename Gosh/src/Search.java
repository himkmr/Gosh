

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gproduct;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		EntityManager em =model.DBUtil.getEmFactory().createEntityManager();
		try {

			String search = request.getParameter("search");
			String q="select t from Gproduct t where t.pname LIKE \"%"+search+"%\"";

			TypedQuery<Gproduct>bq =em.createQuery(q,Gproduct.class);

			List<Gproduct> list=bq.getResultList();
			message+="<table class=\"table table-hover\"><tr><td><b>Product Name </td><td><b>Price</td></tr>";
			for(Gproduct temp:list){
				message+="<td><a href=\"DetailServlet?itemid="+temp.getId()+"\">"+temp.getPname()+"</td><td>"+temp.getPrice()+"</td></tr>";
			}
			message+="</table>";
			request.setAttribute("message", message);

		 getServletContext().getRequestDispatcher("/output1.jsp").forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
