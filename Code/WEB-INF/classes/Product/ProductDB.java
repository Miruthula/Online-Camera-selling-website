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


/**
 *
 * @author Miruthula
 */

public class ProductDB {
    

    public void createProductTable() {

        Statement statement = DbAdmin.getNewStatement();

        try {

            statement.execute("CREATE TABLE product("
                    + "productCode INT,productName VARCHAR(50),"
                    + "categoryCode INT,catalogCategory VARCHAR(50),"
                    + "price FLOAT,description VARCHAR(100),imageUrl VARCHAR(50),"
                    + "PRIMARY KEY (productCode))");
            System.out.println("Created a new table: " + "PRODUCT");
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create PRODUCT table: " + se);
            }
        }
    }

    public Product addProduct(String productCode, String productName, String catalogCategory,
            float price, String description, String imageUrl) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, productCode);
            ps.setString(2, productName);
            ps.setString(3, catalogCategory);
            ps.setFloat(4, price);
            ps.setString(5, description);
            ps.setString(6, imageUrl);

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + productCode);
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode);
            return null;
        }
        System.out.println("Added product to PRODUCT table: " + productCode);

        return new Product(productCode, productName, catalogCategory,price, description, imageUrl);
    }    


    public Product addProduct(Product product) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getProduct_Code());
            ps.setString(2, product.getProduct_Name());
            ps.setString(3, product.getCatalog_Category());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getImage());

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + product.getProduct_Code());
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProduct_Code() + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProduct_Code());
            return null;
        }
        System.out.println("Added product to PRODUCT table: " + product.getProduct_Code());

        // return the  product object
        return product;
    }    

   public Product getProduct(String pcode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query= "SELECT product_Name, product_Code, catalog_Category, price, description, image from product where product.product_Code =?";
        PreparedStatement ps=null;        
        ResultSet resultSet = null;
        Product product = new Product();
        product.setProduct_Code(pcode);
        
        try {
            
            ps = connection.prepareStatement(query); 
            ps.setString(1, pcode);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                product.setProduct_Name(resultSet.getString("product_Name"));
                product.setProduct_Code(resultSet.getString("product_Code"));
                product.setCatalog_Category(resultSet.getString("catalog_Category"));
                product.setPrice(resultSet.getInt("price"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
            }      
        }
            catch (SQLException e)
            {
            e.printStackTrace();
            }
        return product;
   }
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String productCode = null;
        String productName = "";
        String catalogCategory = "";
        double price = 0.0f;
        String description = "";
        String imageUrl = "";

        try {

            
                              resultSet = statement.executeQuery( "SELECT product_Code,product_Name, catalog_Category, price, description, image from product order by product_Code;");
            while (resultSet.next()) {
                productCode = resultSet.getString("product_Code");
                productName = resultSet.getString("product_Name");
                catalogCategory = resultSet.getString("catalog_Category");
                price = resultSet.getDouble("price");
                description = resultSet.getString("description");
                imageUrl = resultSet.getString("image");

                Product product = new Product(productCode, productName,catalogCategory, price, description, imageUrl);
                products.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ProductDB.getAllProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return products;
    }
  public void InsertOrder(int userid,double tax,double total,int paid) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;       
        Order order = new Order();
        try{
         ps = connection.prepareStatement("insert into orders (userID,Taxrate,TotalCost,Paid)values(?,?,?,?);");
            ps.setInt(1, userid);
            ps.setDouble(2,tax);
            ps.setDouble(3, total);
            ps.setInt(4, paid);
            ps.executeUpdate();      
        }
            catch (SQLException e)
            {
            e.printStackTrace();
            }
       
   }
  public int getordernumber() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query= "select max(ordernumber) from orders;";
        PreparedStatement ps=null;        
        ResultSet resultSet = null;
        int ordernumber = 0;     
        
        try {
            
            ps = connection.prepareStatement(query); 
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
            ordernumber=resultSet.getInt("max(ordernumber)");
            ps.executeUpdate();      
        }
        }
            catch (SQLException e)
            {
            e.printStackTrace();
            }
       return ordernumber;
   }
public void insertorderitem(int ordernum,String pcode,int quantity)
 {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;       
        //Order order = new Order();
        try{
         ps = connection.prepareStatement("insert into orderitem(OrderNumber,product_Code,Quantity) values(?,?,?);");
            ps.setInt(1, ordernum);
            ps.setString(2,pcode);
            ps.setInt(3, quantity);
          
            ps.executeUpdate();      
        }
            catch (SQLException e)
            {
            e.printStackTrace();
            }
 }
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
        User user = new User();
        String query= "select o.OrderNumber,u.firstname,o.date,o.TotalCost from  orders o join user u where o.userID=u.userID";
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
}
