/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogController1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import Product.*;
import CatalogController1.CatalogController1;
import CatalogController1.OrderController;
import CatalogController1.AdminController;

/**
 *
 * @author Premkumar
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action= request.getParameter("action");
         HttpSession session=request.getSession();
        admin pro = new admin();
        if (action.equals("viewOrders"))
        {
            
           
           Order order=new Order();
           ArrayList<Order> order1=new ArrayList<Order>();       
            
            order1=pro.getAllUserOrder();
            int a=order1.size();
            if(a==0)
           {
            int temp1=0;
            session.setAttribute("temp1", temp1);
            //Cart=new cart();
                       
           }
           else
          {
           int temp1=1;
          session.setAttribute("temp1", temp1);
          }
          session.setAttribute("orderlist", order1);
          
            
            getServletContext().getRequestDispatcher("/orderlist.jsp").forward(request,response); 
           }
        else if(action.equals("logout"))
        {
            session.removeAttribute("theName");
            getServletContext().getRequestDispatcher("/about.jsp").forward(request,response);
        }
        else
        {
        getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
        }
        }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/HTML");
        PrintWriter out = response.getWriter();
        out.println("success");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
