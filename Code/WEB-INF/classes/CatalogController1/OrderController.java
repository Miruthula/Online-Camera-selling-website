/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogController1;
//import Product.Product;
//import Product.OrderItem;
//import Product.ProductDB;
//import Product.User;
//import Product.UserDB;
//import Product.cart;
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

/**
 *
 * @author Miruthula
 */
//@WebServlet(urlPatterns={"/order","/Add to Cart"})
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action"); // Obtains action value
        String url = null;
        Order o=new Order();
        if(action.equals("updatecart"))
       {
        HttpSession session=request.getSession();
        cart Cart=(cart) session.getAttribute("cart"); //Gets session values
        if(Cart==null)
        {
            Cart=new cart();
        }
         ProductDB data=new ProductDB();                 //Define ProductDB object
         List<OrderItem> c1=new ArrayList<OrderItem>();  // Define Arraylist 
         c1=Cart.getItems();                             // Assign all cart items to object
         int a=c1.size();
         double sum=0;
         for(int i=0;i<c1.size();i++)
         { 
             String[] value = request.getParameterValues("quantity");//assign each value of textbox quantity to array
             if (value[i]==null || value[i].equals(""))
             {
                  request.getRequestDispatcher("/cart.jsp").forward(request,response);
             }
            
             int quantity= Integer.parseInt(value[i]); //Convert to integer
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(c1.get(i).getProduct());
            if(quantity <0)
            {
                
               quantity=1;
              // url="/cart.jsp";
            ///request.getRequestDispatcher("/cart.jsp").forward(request,response);
            }
             orderItem.setQuantity(quantity);
            sum=sum+orderItem.getTotal();
            //set item parameters 
             
            // set quantity values
            if (quantity > 0) {
            Cart.addItem(orderItem);                        // additem
            
               
            } else if (quantity == 0) 
            {
              Cart.removeitem(orderItem);    
            }
            //else if(quantity <0)
            //{
                //orderItem.setQuantity(++quantity);
               // quantity=1;
            //request.getRequestDispatcher("/cart.jsp").forward(request,response);
            //}//remove item
           
            
        }
        
        
        //o.setTotal_cost(sum1);
        session.setAttribute("cart", Cart);
        session.setAttribute("sum",sum);
       
        //url="/cart.jsp";
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
        
         }
       else if(action.equals("Checkout"))
       {
        HttpSession session = request.getSession();
        UserDB data1 = new UserDB();
        User user=(User) session.getAttribute("theuser");
        //        User user1 = data1.getUser(user.getUserID());
      
     //  session.setAttribute("theuser",user1);   
       cart Cart=(cart) session.getAttribute("cart"); //Gets session values
       ArrayList<OrderItem> c1=new ArrayList<OrderItem>();  // Define Arraylist 
       c1=Cart.getItems();                             // Assign all cart items to object
       int a=c1.size();
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
       String sum = session.getAttribute("sum").toString(); 
       double tot = Double.parseDouble(sum); 
       double tax=tot*10/100;       
       double sum1= tot+(tax);
       o.setItems(c1);
       o.setTotal_cost(sum1);
       o.setTax_rate(tax);
       o.setUser(user);     
      
       session.setAttribute("order",o);
       session.setAttribute("sum1", sum1);
       session.setAttribute("cart1", Cart);
       // out.println(o.getTotal_cost());
        //out.println(o.getTax_rate());
         
         //out.println(Cart.getItems().get(1).getTotal());
       // url="/order.jsp";
       request.getRequestDispatcher("/order.jsp").forward(request,response);
        }
        
       //session.removeAttribute("user");
       
       //else if(action.equals("Purchase"))
      // {
      /*HttpSession session=request.getSession();
      session.removeAttribute("cart");
      session.removeAttribute("theuser");
      session.removeAttribute("cart1");
      session.removeAttribute("sum");
      session.removeAttribute("products");
      session.removeAttribute("temp1");*/
     // url="/catalog.jsp";
      //request.getRequestDispatcher("/.jsp").forward(request,response);
      // }
       else if(action.equals("confirmPayment"))
       {
        HttpSession session=request.getSession();
       Order or=(Order)session.getAttribute("order");
       or.setpaid(1);
       ProductDB db = new ProductDB();
       db.InsertOrder(or.getUser().getUserID(), or.getTax_rate(),or.getTotal_cost(),or.getpaid());
       int ordernum=db.getordernumber();
       List<OrderItem> c1=new ArrayList<OrderItem>();  // Define Arraylist 
       c1=or.getItems();                             // Assign all cart items to object
       int a=c1.size();
         
      for(int i=0;i<a;i++)
      { 
        db.insertorderitem(ordernum,or.getItems().get(i).getProduct().getProduct_Code(),or.getItems().get(i).getQuantity());
      }
      session.removeAttribute("cart");
      session.removeAttribute("cart1");
      session.removeAttribute("sum");
      session.removeAttribute("sum1");
      //session.removeAttribute("order");
      session.removeAttribute("products");
      session.removeAttribute("temp1");
      getServletContext().getRequestDispatcher("/invoice.jsp").forward(request,response);
     
        //session.setAttribute("user",user);
       
       
        
       }
       else if(action.equals("viewOrders"))
       {
           HttpSession session=request.getSession();
           User user=(User)session.getAttribute("theuser");
           ProductDB db1 = new ProductDB();
           Order order=new Order();
           ArrayList<Order> order1=new ArrayList<Order>();
           if(user==null)
           {
               getServletContext().getRequestDispatcher("/catalog.jsp").forward(request,response);
           }
           else
           {
            
            order1=db1.getUserOrder(user.getUserID());
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
       }
      
    }
        
         
        

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
               
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
       Order o=new Order();
       
       /* if(action==null)
       {
           action="updatecart";
       }*/
        
       if(action.equals("addcart"))
       {
        String productcode= request.getParameter("ProductList");
        String quantityString = request.getParameter("quantity");
        //out.println(quantityString);
        HttpSession session=request.getSession();
        cart Cart=(cart) session.getAttribute("cart");
        double sum=0;
        if(Cart==null)
        {
            Cart=new cart();
        }
        int quantity ;
        try
        {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0 )
                {
                    quantity = 1;
                }
        } catch (NumberFormatException nfe) 
             {
                quantity = 1;
            }
        
        try
        {
            ProductDB data=new ProductDB();
            Product p1 = data.getProduct(productcode);

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(p1);
            orderItem.setQuantity(quantity);
            if (quantity > 0) {
            Cart.addItem(orderItem);
            }
            List<OrderItem> c1=new ArrayList<OrderItem>();
       
            c1=Cart.getItems();                             // Assign all cart items to object
            int a=c1.size();
            for(int i=0;i<=a;i++)
            { sum=sum+c1.get(i).getTotal();
              
            }
               
            
        }
        
        
        catch (Exception e)
        {
            out.println("An exception occurred in get: " + e.getMessage());
        }
        
       
        
       // sum=sum+orderItem.getTotal();*/
          
            session.setAttribute("cart", Cart);
            session.setAttribute("sum",sum);
            getServletContext().getRequestDispatcher("/cart.jsp").forward(request,response);
           
       }
      
    }
}
