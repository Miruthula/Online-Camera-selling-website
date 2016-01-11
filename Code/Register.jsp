<%-- 
    Document   : Register
    Created on : Nov 15, 2014, 1:17:57 PM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="Login.jsp">Login-></a>
    <a href="Register.jsp">Register</a>
    
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
    <h3>Please fill in the registration form</h3>
    <form action="UserController" method="get">
    
    Firstname&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="firstname">
    Lastname&nbsp&nbsp;&nbsp;: <input type="text" required="required" name="lastname"><br><br>
    Gender: <input type="radio" checked  name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br><br>
   
    Email Address&nbsp&nbsp;&nbsp;: <input type="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" required="required" name="email"><br><br>    
    Password&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="password" name="password"><br><br>
    Please select your security Question<br><br>
    <select name="security">
        <option selected value="What is your Mother's Maiden name?">What is your Mother's Maiden name?</option>
        <option value="Who is your favourite teacher?">Who is your favourite teacher?</option>
        <option value="Who is your childhood best friend?">Who is your childhood best friend?</option>
        <option value="What is your favourite pet?">What is your favourite pet?</option>
    </select>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Answer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <input type="text" required="required"  name="answer"><br><br>
    Address Line1: <input type="text" required="required"  name="line1">&nbsp;
    Address Line2: <input type="text" required="required"  name="line2"><br><br>
    City &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required"  name="city">
    &nbsp;State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required"  name="state"><br><br>
    Country &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="Country">
    &nbsp;Pin &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="number" required="required" name="pin"><br><br><br>
    
    <input type="submit" value="Register" name="register">&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="Reset" name="reset">
    * Please login after registration
    </form>
    </div>
</div>
<%@ include file= "footer.jsp" %>
