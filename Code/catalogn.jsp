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
    <a href="catalogn.jsp">Nikon</a>
</div>
<div id="sidebarcenter">
  <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
                <h4> Brands We Offer Are Below </h4> 
                &nbsp;&nbsp;&nbsp;<img src="Image3.jpg" alt=""/>
                <form action="CatalogController1" method="get">
                <p class="p2"> NIKON       :
                <select name="productcode"> 
                    <option value="0" label="Select">Select</option>
                    <option label="Nikon Coolpix L620" value="a4">Nikon Coolpix L620</option>
                    <option label="Nikon Coolpix P520" value="a5">Nikon Coolpix P520 </option>
                    <option label="Nikon D5100" value="a6">Nikon D5100 </option>
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
