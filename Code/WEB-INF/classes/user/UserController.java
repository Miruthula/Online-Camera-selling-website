package user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CatalogController1;

import Product.UserDB;
import CatalogController1.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import Product.*;

/**
 *
 * @author Admin
 */
public class UserController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String gender=request.getParameter("gender"); 
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String question=request.getParameter("security");
        String answer=request.getParameter("answer");  
        String address1=request.getParameter("line1");
        String address2=request.getParameter("line2");
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        String country=request.getParameter("Country");
        String pincode=request.getParameter("pin");
        int pin=Integer.parseInt(pincode);
        UserDB userdb=new UserDB();
        userdb.addingUser(firstname, lastname, gender, email, password, question, answer, address1, address2, city, state, country, pin);
       // userdb.addingUser(firstname, lastname, gender, email, password, question, answer, address1, address2, city, state, country, pin);
       request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
