<%-- 
    Document   : payment
    Created on : Nov 22, 2014, 7:26:40 PM
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
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
  
    <h3>Enter your payment information</h3>

   
    Credit card type &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
    <select name="cardtype">
        <option selected value="VISA">VISA</option>
        <option value="MASTERCARD">MASTERCARD</option>
        <option value="AMERICAN EXPRESS">AMERICAN EXPRESS</option>
        
    </select> <br><br><br>
    Card Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required=required maxlength="16" name="cardnum"><br><br></p>
    Expiration date (MM/YYYY)&nbsp;:
    <select name="month">
      
        <option selected value="01">01</option>
        <option value="02">02</option>
        <option value="03">03</option>
        <option value="04">04</option>
        <option value="05">05</option>
        <option value="06">06</option>
        <option value="07">07</option>
        <option value="08">08</option>
        <option value="09">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        
         
    </select> 
    <select name="year">
        <option selected value="2014">2014</option>
        <option value="2015">2015</option>
        <option value="2016">2016</option>
        <option value="2017">2017</option>
        <option value="2018">2018</option>
        <option value="2019">2019</option>
        <option value="2020">2020</option>
        <option value="2021">2021</option>
        <option value="2022">2022</option>
        <option value="2023">2023</option>
        
        
    </select><br><br></p>
    CVV(3 digit)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text" pattern="[0-9]" maxlength="3" name="cvv"><br><br></p>
     
    Your card will be charged a total of :  $ ${sum1} <br><br></p>
    
 
    <form action="OrderController" method="get"><input name="action" type="submit" value="confirmPayment"></form>
    


</div>
</div>

<%@ include file= "footer.jsp" %>
