<%-- 
    Document   : item
    Created on : Sep 16, 2014, 3:59:05 PM
    Author     : Miruthula
--%>

<%@ page import="java.util.List, Product.Product,Product.ProductDB" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="item1.jsp">Item</a>    
</div>
<div id="sidebarcenter"> 
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
    <h4>${products.product_Name}</h4>
    <p class="pp"> Camera Category: ${products.catalog_Category}  &nbsp; Price ($):${products.price}</p>
    &nbsp;&nbsp;&nbsp;&nbsp;<img id="imagel" src="${products.image}" alt="Image"/>
    <p> ${products.description}</p>
    <form action="OrderController" method="post">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="hidden" name="ProductList" value="${products.product_Code}"/>
        <input type="hidden" name="action" value="addcart">
        <input type="submit" value="Add to Cart">
    </form> 
    <form action="catalog.jsp">
        <button type="submit">Back</button>
    </form>
</div> 
        </div>

<%@ include file= "footer.jsp" %>
                      
               
      
            