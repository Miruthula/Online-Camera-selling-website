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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
     <c:when test="${theName== null}">
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="item1.jsp">Item-></a>
    <a href="cart.jsp">Cart-></a>
    <a href="order.jsp">Order-></a>
    <a href="payment.jsp">Payment-></a>
    <a href="orderlist.jsp">OrderList</a>
</div>
</c:when>
     <c:otherwise>
    <div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="<c:url value='/admin/index.jsp'/>">Admin-></a>
    <a href="orderlist.jsp">Display all order</a>
   
</div>
     </c:otherwise>
 </c:choose>
<div id="sidebarcenter">
    <c:choose>
        <c:when test="${theName== null}">
            <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
        </c:when>
        <c:otherwise>
            <div id="place">
        <p>Welcome ${theName}  </p>
            </div>
        </c:otherwise>
    </c:choose>
    
   
    <c:choose>
        <c:when test="${temp1==1}"> 
      
    <h3>Your Orders</h3>
            
    <table>
        <tr>
        <th>ORDER NUMBER</th>
        <th>CUSTOMER</th>
        <th>DATE</th>
        <th>TOTAL COST</th>
        </tr>
        
        <c:forEach var="item" items="${orderlist}">
  
            <tr>  
    
                <td><c:out value='${item.order_number}'/></td>
        <td><c:out value='${item.user.firstname}'/></td>
            
    
        <td><c:out value='${item.date}'/></td>
   
        <td> $ <c:out value='${item.total_cost}'/></td> </tr>

</c:forEach> 
 </c:when> 
    <c:otherwise>
      
        <h3>Your Orders</h3><br>
       <p> There were no orders placed till now !! </p>
       
       

    </c:otherwise>   
    
                </c:choose>  
                    
</table>
</div>
</div>

<%@ include file= "footer.jsp" %>