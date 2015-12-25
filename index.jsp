<%-- 
    Document   : index
    Created on : 16 Sep, 2014, 11:31:19 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home</a>
</div>

<div id="sidebarcenter">
<div id="place">
        <p>Welcome ${theuser.firstname} </p>
    </div>
    <h3> Welcome to CAMZONE !! </h3>
    <p>Any CAM you need! <br>Anytime you need it! <br>However you need it!<br>WE WILL MAKE IT HAPPEN FOR YOU !!!</p>
    &nbsp;&nbsp;&nbsp;&nbsp; <img src="Image4.jpg" alt="Image"/>
    <p>We try to make shopping EASY, COMFORTABLE, FAST with just a click away, at the best REASONABLE PRICES!!!</p>
    <p>CAMZONE-EZBUY !The name says it all .. Its the place where everything is served with QUALITY & WARRANTY </p>
</div>
</div>
<%@ include file= "footer.jsp" %>

