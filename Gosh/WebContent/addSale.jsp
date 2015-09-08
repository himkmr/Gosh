<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Gosh, the E-Lemon-ators</title>
</head>
<jsp:include page="header.jsp"/>

<body  style="background-image:url(back.jpg);  background-position:50% -20%; background-repeat:no-repeat;">


<div align="center">

<form style="width:40%;" action="addForSale" id="myform">
    <label for="pname">Product Name</label>
    <input type="text" class="form-control" name="pname" placeholder="Product Name">
    <label for="price">Price</label>
    <input type="text" class="form-control" name="price" placeholder="price">
    <label for="description">Description</label>
    <input type="text" class="form-control" name="description" placeholder="description">
    <label for="quantity">Quantity</label>
    <input type="text" class="form-control" name="quantity" placeholder="quantity">
    <label for="picture">Picture Url</label>
    <input type="text"  class="form-control" name="pic" >
    <label for="scost">Shipping Cost</label>
    <input type="text" class="form-control" name="scost" placeholder="Shiping Cost">
    <label for="availability">Availability?</label>
<select name ="available">
  <option value="no">No</option>
  <option value="yes">Yes</option>
</select>
  <button type="submit" class="btn btn-default">Add Product</button>
</form></div>
</body>
</html>