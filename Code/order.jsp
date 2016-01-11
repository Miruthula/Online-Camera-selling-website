<%-- 
    Document   : order
    Created on : 17 Sep, 2014, 12:28:24 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="item1.jsp">Item-></a>
    <a href="cart.jsp">Cart-></a>
    <a href="order.jsp">Order</a>
</div>
<div id="sidebarcenter">
    <c:choose>
        <c:when test="${theuser.firstname==null}">
            Your not Logged in.Please <a href="login.jsp">Login</a> to proceed with the order.
        </c:when>
        <c:otherwise>
 <c:choose>
        <c:when test="${temp1==1}"> 
    <div id="place">
    
        
                <p>Welcome ${theuser.firstname} !!</p>
    </div>
                <h4> Invoice</h4><br>
    
   
        <p> SHIPPING ADDRESS: <br>
        ${theuser.firstname}&nbsp;${theuser.lastname} <br>
        ${theuser.address1},${theuser.address2}&nbsp;${theuser.city},${theuser.state}-${theuser.pin}<br>       
        EMAIL: ${theuser.email}
        
      
    
            
    <table>
        <tr>
        <th>ITEM NAME</th>
        <th>QUANTITY</th>
        <th>PRICE</th>
        <th>TOTAL</th>
        </tr>
        
        <c:forEach var="item" items="${cart1.items}">
  
            <tr>  
    
                <td><c:out value='${item.product.product_Name}'/></td>
        <td><c:out value='${item.quantity}'/></td>
            
    
        <td> $ <c:out value='${item.product.price}'/></td>
   
        <td>  <c:out value='${item.getTotalCurrencyFormat()}'/></td> </tr>

</c:forEach> 
</table>
            
    <p class="p3"> SUBTOTAL :$ ${sum}<br>
       TAX      :     10% <br>
       TOTAL    : $ ${sum1} </p>
    <form action="cart.jsp"> <input class="one" type="submit" value="Back to Cart"/></form>
    <form action="payment.jsp" method="get"><input name="action" type="submit" value="Purchase"></form>
   
</c:when> 
    <c:otherwise>
        <div id="place1">
        
                <p>Welcome!!</p>
    </div>
                <h4> Invoice</h4><br>
       <p> There are no items in the cart</p>
       <p> please choose items from the catalog</p>
       <a href="catalog.jsp">Catalog</a>

    </c:otherwise>   
    
                </c:choose>  
        </c:otherwise>
    </c:choose>
                    
</div>
</div>

<%@ include file= "footer.jsp" %>