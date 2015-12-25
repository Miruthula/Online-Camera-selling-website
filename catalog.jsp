<%-- 
    Document   : catalog
    Created on : Sep 16, 2014, 1:31:08 PM
    Author     : Miruthula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog</a>
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
            <h4> Brands We Offer Are Below </h4> 
            &nbsp;&nbsp;&nbsp;<img src="Image3.jpg" alt=""/>
            <form action="CatalogController1" method="post">
                  
                <p class="p2"> Choose Category       :
                <select name="id"> 
                    <option value="select"> Select </option>
                    <option label="Sony" value="Sony" >Sony </option>
                    <option label="Nikon" value="Nikon">Nikon  </option>                  
                </select>
                    <input type="submit" value="Submit"> 
            </form>       
</div>
</div>

<%@ include file= "footer.jsp" %>
