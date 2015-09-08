<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">
  <h2>Create Account</h2>
  <form role="form" action="CreateServlet" method="post">
    <div class="form-group">
      <label >Name:</label>
      <input type="text" class="form-control" id="new_name" name= "new_name">
    </div>
    <div class="form-group">
      <label >Username:</label>
      <input type="text" class="form-control" id="new_username" name= "new_username">
    </div>
    <div class="form-group">
      <label >Password:</label>
      <input type="text" class="form-control" id="new_password" name= "new_password">
    </div>
    <button type="submit" class="btn btn-default">Create Account</button>
  </form>
</div>


<jsp:include page="footer.jsp"/>

</body>
</html></html>