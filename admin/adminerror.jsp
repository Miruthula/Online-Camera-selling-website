<%-- 
    Document   : adminerror
    Created on : Nov 30, 2014, 1:53:50 PM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file= "/header.jsp" %>
<%@ include file= "/user-navigation.jsp" %>
<%@ include file= "/site-navigation.jsp" %>
<div id="placeholder">
    <a href="/index.jsp">Home-></a>
    <a href="index.jsp">Admin</a>
   
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
  
      
    <h2>Error in Login</h2>
    <p> Please try logging in again !! <a href ="index.jsp"> Click here </a></p>
    
       </div>
</div>


<%@ include file= "/footer.jsp" %>