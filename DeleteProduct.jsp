<%@ include file = "AdminHeader.jsp" %>
<body>
<div class="jumbotron">
<center>
  <h1>Hello, Admin!</h1>
  <p>Delete your products here</p>
  <center>
  <li><span class="glyphicon glyphicon-hand-down"></span></a></li>
  </center>
<form:form method="POST" action="delete" commandName="Product">
<table>
<tr><td>prod_id :</td><td><form:input path="id" /></form>
<tr><td>prod_name :</td><td><form:input path="name" /><tr><td>
<tr><td>prod_description :</td><td><form:input path="description" row="5" col="4" /></td></tr>
<tr><td>price :</td><td><form:input path="price" /></td></tr>

 <tr>
        <td colspan="2"><input type="submit" value="Submit"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="reset" value="Reset"></td>
    </tr>
</table>
 </form:form>
 </body>
 <%@ include file = "Footer.jsp" %>