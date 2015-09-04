

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
 * Servlet implementation class EditItem
 */
@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("id"));
		String message = "";
		List<Gproduct> mylist = DBUtil.getProductList(pid);
		String prod = "";
		for (Gproduct temp: mylist)
		{

		message+="<form style=\"width:50%;\" class=\"form-horizontal\" action=\"UpdateProduct\" id=\"myform2\">"+
				"<div class=\"form-group\" >"+
				"<label class=\"control-label col-sm-2\" for=\"name\">Product Name</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" name=\"pname\" class=\"form-control\" value ="+temp.getPname()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Description</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"description\" value='"+temp.getDescription()+"'>"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\" >Price</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"price\" value="+temp.getPrice()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Quantity</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"quantity\" value="+temp.getIquantity()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Picture</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"picture\" value="+temp.getPicture()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Shipping Cost</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"scost\" value="+temp.getSCost()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Availability</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"available\" value="+temp.getAvailable()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-8\" for=\"text\"></label>"+
		  "<div class=\"col-sm-4\">"+
		    "<input type=\"submit\" class=\"form-control\"  value= \"update\"></div></div>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"hidden\" class=\"form-control\" name=\"pid\" value="+pid+">"+
		  "</div>"+
		    
		"</form>"
		    + "<form style=\"width:50%;\" class=\"form-horizontal\" action=\"DeleteProduct\"><div class=\"form-group\">"+
				    "<label class=\"control-label col-sm-8\" for=\"text\"></label>"+
					  "<div class=\"col-sm-4\">"+
					    "<input type=\"submit\" class=\"form-control\"  value= \"delete\"></div></div>"+
					    "<div class=\"col-sm-10\">"+
							    "<input type=\"hidden\" class=\"form-control\" name=\"pid\" value="+pid+">"+
							  "</div>"+
					"</form>";
	}

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
	}
}
