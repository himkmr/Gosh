<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
li {
    font-size: 152%;
  
}
.navbar {
  text-align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div>
      <ul class="nav navbar-nav">

        <li><a href="index.jsp"><img src="elemonator.png" width =172 height = 53></a></li>
        <li><a href="list">Products</a></li>
       
        <%if(request.getSession().getAttribute("username")==null){%>
        	<li><a href="login.jsp">Login</a></li>
        	<li><a href="CreateAccount.jsp">Create Account</a></li>
        <%}else{%>
            <li><a href="viewForSale">Your Products </a></li>
              <li><a href="ViewCartServlet">Cart</a></li>
              <li><a href="ViewPurchases">Purchased Items</a></li>
              <li><a href="logout">Logout</a></li>
 
              
        <%} %>
<li style="font-size: 120%;"><form class="form-inline" action="Search">
		<input type="text" name  ="search">
		<input type="submit" value="Search">
		</form></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>