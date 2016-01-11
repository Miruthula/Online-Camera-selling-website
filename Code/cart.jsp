<%-- 
    Document   : cart
    Created on : 16 Sep, 2014, 4:03:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="item1.jsp">Item-></a>
    <a href="cart.jsp">Cart</a>
</div>
    <div id="sidebarcenter">
        <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
        <h4> Your Cart </h4>
        <c:choose>
            <c:when test="${cart==null&&cart1==null}">
                 <p> There are no items in the cart</p>
       <p> please choose items from the catalog</p>
       <a href="catalog.jsp">Catalog</a>
            </c:when>
            <c:otherwise>
        <p> Items added to cart : </p>
       
        <form action="OrderController" method="get">
        <table>
            <tr>
                <th>ITEM</th>
                <th>QUANTITY</th>
                <th>PRICE</th>
                <th>TOTAL</th>
              
            </tr>
            
 
  <c:forEach var="item" items="${cart.items}">
  <tr>
    <td>
      <c:out value='${item.product.product_Name}'/>
    </td>
    
     <td>
         
         <input type="number" required="required" name="quantity" value="<c:out value='${item.quantity}'/>"/>
    </td> 
    <td>
      $<c:out value='${item.product.price}'/>
    </td>     
    <td>${item.getTotalCurrencyFormat()}</td>
   </tr>
   
</c:forEach>
            
        </table>
            
        <p class="p3">Subtotal:$ ${sum}</p>
        <input type="hidden" name="action" value="updatecart"><input type="submit" value="Update Cart"></form>
       <form action="OrderController" method="get"><input name="action" type="submit" value="Checkout"></form>
       <!-- <form action="addcart"><input name="action" class="one" type="submit" value="Update Cart"/></form>
        <form action="checkout"><input class="one" type="submit" value="Checkout"/></form>-->
        <p>* To remove an item change quantity to zero </p>
            </c:otherwise>
        </c:choose>
</div>
</div>


<%@ include file= "footer.jsp" %>