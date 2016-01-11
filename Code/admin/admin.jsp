<%-- 
    Document   : admin
    Created on : Nov 22, 2014, 8:00:12 PM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="admin.jsp">Admin</a>
   
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
  
    <form action="AdminController" method="get">
    <h2>Administrative Menu</h2>
    
    <input type="hidden" name="action" value="viewOrders"><input type="submit" value="Display All Orders"></form>
    </div>
</div>


<%@ include file= "footer.jsp" %>
