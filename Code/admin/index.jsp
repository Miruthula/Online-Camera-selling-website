<%-- 
    Document   : index
    Created on : Dec 1, 2014, 1:51:55 AM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   session.setAttribute( "theName", "Admin" );
%>
<%@ include file= "/header.jsp" %>
<%@ include file= "/user-navigation.jsp" %>
<%@ include file= "/site-navigation.jsp" %>
<div id="placeholder">
    <a href="/index.jsp">Home-></a>
    <a href="index.jsp">Admin</a>
   
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theName}  </p>
    </div>
  
        <form action="<c:url value='/AdminController'/>" method="get">
    <h2>Administrative Menu</h2>
    
    <input type="hidden" name="action" value="viewOrders"><input type="submit" value="Display All Orders"></form>
    </div>
</div>


<%@ include file= "/footer.jsp" %>
