<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="AdminHeader.jsp"%>

<body>
	<!-- div class="jumbotron">
<center>
  <h1>Hello, Admin!</h1>
  <p>Add your products here</p>
<center>
<a><li><span class="glyphicon glyphicon-hand-down"></span></a></li>
 </center -->
	<form:form method="POST" action="add" commandName="product" enctype="multipart/form-data">
		<table>
			
			<tr>
				<td>prod_name :</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>prod_description :</td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
			<td>category  :</td>
				<td><form:input path="category"/></td>
			</tr>
			
			<tr>
			<td>prod_image :</td>
				<td><form:input type="file" path="image"/></td>
			</tr>
			
			

			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form:form>
	<!-- </center>
 </div> -->
</body>
<%@ include file="Footer.jsp"%>