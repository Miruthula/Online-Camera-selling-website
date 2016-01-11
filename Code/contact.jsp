<%-- 
    Document   : contact
    Created on : 16 Sep, 2014, 12:24:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="contact.jsp">Contact</a>
</div>
    <div id="sidebarcenter">
        <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
        <div id="Contact">
            <br><br><br><br><br><br><br>
            <img src="Image2.jpg" alt="Image"/>
            <p> Anytime you need us !! <br>
            <br> Email:custsupport@ezbuy.com
            <br> Address : #190/B, HZ Plaza 
            <br> Headquarters : Charlotte ,NC
            <br> Telephone : 98530256589
            <br> Fax No : 91-80-26799278 </p>
        </div>
    </div>
</div>
<%@ include file= "footer.jsp" %>
    
