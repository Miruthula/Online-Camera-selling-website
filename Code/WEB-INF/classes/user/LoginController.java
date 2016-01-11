
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import Product.User;
import Product.UserDB;
import Product.cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Premkumar
 */
public class LoginController extends HttpServlet {

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
       HttpSession session=request.getSession();
       
       String action=request.getParameter("action");
       if(action.equals("logout"))
       {
      session.removeAttribute("cart");
      session.removeAttribute("theuser");
      session.removeAttribute("cart1");
      session.removeAttribute("sum");
      session.removeAttribute("products");
      session.removeAttribute("temp1");
     String url="/catalog.jsp";
     request.getRequestDispatcher(url).forward(request,response);
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
        HttpSession session=request.getSession();
        String useremail=request.getParameter("email");
        //EmailValidator validator=new EmailValidator();
        final JPanel panel=new JPanel();
        String password=request.getParameter("password");
        User user=(User) session.getAttribute("theuser");
        cart Cart=(cart) session.getAttribute("cart");
        UserDB db=new UserDB();
        if(user==null)
        {
            boolean a = db.UseremailExists(useremail);
            if (a== true)
            {
                User u=db.getPassword(useremail);
                if (u.getPassword().equals(password))
                {
                    session.setAttribute("theuser", u);
                    if(Cart==null){
                    request.getRequestDispatcher("/catalog.jsp").forward(request, response);}
                    else{
                       request.getRequestDispatcher("/cart.jsp").forward(request, response);}

                    }
                    
                
                else
                {
                    JOptionPane.showMessageDialog(panel, "The UserID/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    
                }
            }
            else
            {
                JOptionPane.showMessageDialog(panel, "The UserID/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            
            }
        }
    
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
