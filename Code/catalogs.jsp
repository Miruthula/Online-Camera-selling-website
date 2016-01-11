<%-- 
    Document   : catalogs
    Created on : Sep 21, 2014, 6:37:46 PM
    Author     : Miruthula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="catalog.jsp">Catalog-></a>
    <a href="catalogs.jsp">Sony</a>
</div>
<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
    <h4> Brands We Offer Are Below </h4> 
    &nbsp;&nbsp;&nbsp;<img src="Image3.jpg" alt=""/>
    <form action="CatalogController1" method="get">
        <p class="p2"> SONY         :
        <select name="productcode"> 
            <option value="0"> Select </option>
            <option label="Sony DSC W320" value="a1" >Sony DSC W320 </option>
            <option label="Sony Cyber - H20" value="a2">Sony Cyber - H20  </option>
            <option label="Sony A6000" value="a3">Sony A6000</option>
        </select>
        <input type="submit" value="Submit"> 
        </p>
        <br>
    </form>
    <form action="catalog.jsp">
        <button type="submit">Back</button>
    </form>
</div>
</div>


<%@ include file= "footer.jsp" %>
