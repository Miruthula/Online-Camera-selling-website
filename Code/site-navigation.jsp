<%-- 
    Document   : site-navigation
    Created on : 16 Sep, 2014, 11:34:33 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div id="header2">
        <c:choose>
            <c:when test="${theName==null}">
                <div id="sidebarleft"> 
            <div id="catalog">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="catalog.jsp">Catalog</a></li>
                    <li><a href="catalog.jsp">New Arrivals</a></li>
                    <li><a href="contact.jsp">Contact Us</a></li>
                    <li><a href="about.jsp">About Us</a></li> 
                </ul>
            </div>                
        </div>
        </c:when>
            <c:otherwise>
                <div id="sidebarleft"> 
            <div id="catalog">
                <ul>
                <li><a href="<c:url value='/admin/index.jsp'/>">Home</a></li>
                
                </ul>
            </div>
                </div>
            </c:otherwise>
        </c:choose>
        
