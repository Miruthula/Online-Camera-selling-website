<%-- 
    Document   : invoice
    Created on : Dec 1, 2014, 2:32:36 PM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="item1.jsp">Item-></a>
    <a href="cart.jsp">Cart-></a>
    <a href="order.jsp">Order-></a>
    <a href="payment.jsp">Payment</a>
    <a href="invoice.jap">Invoice</a>
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
  
    <h2>Paid in full</h2>      
    

</div>
</div>

<%@ include file= "footer.jsp" %>
