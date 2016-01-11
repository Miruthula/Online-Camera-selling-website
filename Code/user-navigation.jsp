<%-- 
    Document   : user-navigation
    Created on : 16 Sep, 2014, 11:32:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div id="header1">
        <c:choose>
            <c:when test="${theuser.firstname==null && theName==null}">
                <a href="login.jsp">Login</a>
                <a href="cart.jsp">Cart</a>        
                <a href="http://localhost:8080/ezbuy/OrderController?action=viewOrders">My Orders</a>
                <a href="admin"> Admin Login</a>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${theuser.firstname !=null && theName==null}">
                        <a href="http://localhost:8080/ezbuy/LoginController?action=logout">Logout</a>
                        <a href="cart.jsp">Cart</a>        
                        <a href="http://localhost:8080/ezbuy/OrderController?action=viewOrders">My Orders</a>
                    </c:when>
                    <c:otherwise>
                        <a href="http://localhost:8080/ezbuy/AdminController?action=logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        
        
        
            
      
        
    </div>
 