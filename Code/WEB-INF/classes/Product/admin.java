/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Product.ConnectionPool;

/**
 *
 * @author Premkumar
 */
public class admin {
    public ArrayList<Order> getUserOrder(int userid)
 {
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<Order> orders=new ArrayList<Order>();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;
        //Order order = new Order();
        User user = new User();
        String query= "select o.OrderNumber,u.firstname,o.date,o.TotalCost from  orders o join user u where o.userID=u.userID and o.userID="+userid;
        ResultSet resultSet = null;
          
        
        try {
            
            ps = connection.prepareStatement(query); 
            resultSet = ps.executeQuery();
            while (resultSet.next()) 
            {
                Order order = new Order();
                order.setOrder_number(resultSet.getInt("o.OrderNumber"));
                user.setFirstname(resultSet.getString("u.firstname"));
                order.setUser(user);
                order.setDate(resultSet.getString("o.date"));
                order.setTotal_cost(resultSet.getDouble("o.TotalCost"));
                orders.add(order);
                
            }
            
                 
        }
        
            catch (SQLException e)
            {
            e.printStackTrace();
            }
         return orders;
 }

public ArrayList<Order> getAllUserOrder()
 {
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<Order> orders=new ArrayList<Order>();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;
        //Order order = new Order();
        
        String query= "select o.OrderNumber,u.firstname,o.date,o.TotalCost from  orders o join user u where o.userID=u.userID";
        ResultSet resultSet = null;
          
        
        try {
            
            ps = connection.prepareStatement(query); 
            resultSet = ps.executeQuery();
            while (resultSet.next()) 
            {
                Order order = new Order();
                User user = new User();
                order.setOrder_number(resultSet.getInt("o.OrderNumber"));
                user.setFirstname(resultSet.getString("u.firstname"));
                order.setUser(user);
                order.setDate(resultSet.getString("o.date"));
                order.setTotal_cost(resultSet.getDouble("o.TotalCost"));
                orders.add(order);
                
            }
            
                 
        }
        
            catch (SQLException e)
            {
            e.printStackTrace();
            }
         return orders;
 }
    
}
