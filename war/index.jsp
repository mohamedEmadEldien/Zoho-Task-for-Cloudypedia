<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page import="java.util.Vector"%>
    <%@page import="com.zohotask.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<% Vector<Item> items = new Vector<Item>();
ZohoOperations obj = new ZohoOperations();
items=(Vector<Item>) obj.getitems().clone();
%>

<script type="text/javascript">
function showprice(obj)
{
	
	var index=obj.selectedIndex; 
	var Salaries=[];
	
	<%for(int i=0;i<items.size();i++){%>
	Salaries[<%=i%>]=<%= items.get(i).getPrice() %>;
	
	<%}%>
	
	document.getElementById("price").value=Salaries[index];

}
</script>

</head>
<body>



<form method="post" >
	<table>
		<tr>
			<td> Item</td>
			<td>
			<select  onChange=showprice(this)>
			 
			 <%for(int i=0;i<items.size();i++){ %>
			 
 				 <option value=<%=items.get(i).getName() %> > <%=items.get(i).getName() %></option>
  				<% } %>
				</select>
			</td>
			<td>  Enter Quantity</td>
			<td>
				 <input type="text" name="qty" size="4">
			</td>
			<td>  Price of unit</td>
			<td>
			
				 <input type="text" id="price" name="price" size="4" value=<%=items.get(0).getPrice() %>>
			</td>
	   </tr>
		
                </table>
	</form>

</body>
</html>