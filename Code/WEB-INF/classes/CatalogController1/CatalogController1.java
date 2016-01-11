/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogController1;

import Product.ProductDB;
import Product.Product;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Miruthula
 */
//@WebServlet(urlPatterns={"/display","/display2"})
public class CatalogController1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                 
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        PrintWriter out = response.getWriter();
        
        String productCode = request.getParameter("productcode"); //Get parameter
        String url;  
      //  try
      //  {
        ProductDB data = new ProductDB();
        Product p = data.getProduct(productCode);
        HttpSession session = request.getSession();
        session.setAttribute("products",p); 
        //List<String> cart=new ArrayList<String>();
        //session.setAttribute("cart",cart);
        if(("a1".equals(productCode))|| ("a2".equals(productCode))||("a3".equals(productCode))||("a4".equals(productCode))||("a5".equals(productCode))||("a6".equals(productCode)) )   
        {
            url ="/item1.jsp";
        }
       
        else if("0".equals(productCode))
        {            
            url = "/catalog.jsp";
            
        }
        else
            {
                url = "/catalog.jsp";
            }
       
        getServletContext().getRequestDispatcher(url).forward(request,response);
        //}
        //catch(Exception e)
        //{
           // out.println("An exception occurred in get: " + e.getMessage());
        //}
    }
               
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String catalogitem = request.getParameter("id");
        PrintWriter out = response.getWriter();
        String url = null;
        try
        {
        if("Sony".equals(catalogitem)) 
         {
             url="/catalogs.jsp";
             //request.getRequestDispatcher("/catalogs.jsp").forward(request,response);
            
         } 
        else if("Nikon".equals(catalogitem))
         {
             url="/catalogn.jsp";
             //request.getRequestDispatcher("/catalogn.jsp").forward(request,response);
         }
         else
        {
            url="/catalog.jsp";           
            //request.getRequestDispatcher("/catalog.jsp").forward(request,response);
        }
        }
         catch(Exception e)
        {
            out.println("An exception occurred in post: " + e.getMessage());
        }
       
        request.getRequestDispatcher(url).forward(request,response);
           
    }
}

  