/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Miruthula
 */
public class UserDB {
   
    public void createUserTable() {

      Statement statement = DbAdmin.getNewStatement();

        try {
            statement.execute("CREATE TABLE users("
                    + "userID int,firstName VARCHAR(50),"
                    + "lastName VARCHAR(50), emailAddr VARCHAR(50),"
                    + "address1 VARCHAR(50), address2 VARCHAR(50),"
                    + "city VARCHAR(50),state VARCHAR(50),pin int,"
                    + "country VARCHAR(50),"
                    + "PRIMARY KEY (userID))");

            System.out.println("Created a new table: " + "USER");
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create USER table: " + se);
            }
        }
    }

     public void addingUser(String firstName, String lastName,String gender, String email,String password,String question,
            String answer,String address1, String address2, String city, String state,
             String country,int pin) 
     {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement insertRow;
        // insert the new row into the table
        try {
            insertRow = connection.prepareStatement("INSERT into user(firstname,lastname,gender,email,password,question,answer,address1,address2,city,state,country,pin) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insertRow.setString(1, firstName);
            insertRow.setString(2, lastName);
            insertRow.setString(3, gender);
            insertRow.setString(4, email);
            insertRow.setString(5, password);
            insertRow.setString(6, question);
            insertRow.setString(7, answer);
            insertRow.setString(8, address1);
            insertRow.setString(9, address2);
            insertRow.setString(10, city);
            insertRow.setString(11, state);
            insertRow.setString(12, country);
            insertRow.setInt(13, pin);
           
           
           
            insertRow.executeUpdate();

        } 
        
         catch (Exception e) 
         {
            
        }
      
     }
 

    public User addUser(User user) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress1());
            ps.setString(6, user.getAddress2());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());
            ps.setInt(9, user.getPin());
            ps.setString(10, user.getCountry());
            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into USER; dup primary key: " + user.getUserID());
            } else {
                System.out.println("ERROR: Could not add row to USER table: " + user.getUserID() + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to USER table: " + user.getUserID());
            return null;
        }
        System.out.println("Added user to USER table: " + user.getUserID());

        // return the  User object
        return user;
    }
    

    public User getUser(int userID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT firstName, lastName, email, address1, address2, city, state, pin, country FROM USER WHERE userID = ?";
        PreparedStatement ps=null;        
        ResultSet resultSet = null;
        Product product = new Product();
        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        int pin=0;
        String country = "";

        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query); 
            ps.setInt(1,userID );
            resultSet = ps.executeQuery();
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                address1 = resultSet.getString("address1");
                address2 = resultSet.getString("address2");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                pin = resultSet.getInt("pin");
                country = resultSet.getString("country");

                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }

        return new User(userID, firstName, lastName, email, address1, address2, city, state, pin, country);
    }

    public ArrayList<User> getAllUsers() 
    {
        ArrayList<User> users = new ArrayList<User>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        int userID=0;
        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        int pin=0;
        String country = "";
        
        try {
            // Find the speciic row in the table
            resultSet = statement.executeQuery(
                    "SELECT userID,firstName, lastName, email, address1, address2, city, state, pin, country FROM USER");
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                address1 = resultSet.getString("address1");
                address2 = resultSet.getString("address2");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                pin = resultSet.getInt("pin");
                country = resultSet.getString("country");
                
    
                User user = new User(userID, firstName, lastName, email, address1, address2, city, state, pin, country);
                
                users.add(user);
                System.out.println("Found user in USER table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return users;
    }
    
   public User getPassword(String useremail) 
    {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();              
        String query= "SELECT userID,password,firstName, lastName, email, address1, address2, city, state, pin, country from user where email='"+ useremail +"'";
        PreparedStatement ps;
        User user=new User();
        ResultSet resultSet = null;
       
       
       
        try {
            ps = connection.prepareStatement(query); 
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
             user.setPassword(resultSet.getString("password"));
             user.setEmail(resultSet.getString("email"));
             user.setFirstname(resultSet.getString("firstname"));
             user.setLastname(resultSet.getString("lastName"));
             user.setAddress1(resultSet.getString("address1"));
             user.setAddress2(resultSet.getString("address2"));
             user.setCity(resultSet.getString("city"));
             user.setState(resultSet.getString("state"));
             user.setCountry(resultSet.getString("country"));
             user.setPin(resultSet.getInt("pin"));
             user.setUserID(resultSet.getInt("userID"));
                                 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }
   
   public boolean UseremailExists(String useremail) 
    {
         User u = new User();
         u.setEmail(useremail);
         ConnectionPool pool = ConnectionPool.getInstance();
         Connection connection = pool.getConnection(); 
         PreparedStatement ps;
        String query= "SELECT count(*) from pisp.user_details where username='"+ useremail +"'";
        ResultSet resultSet = null;
        try 
        {
            ps = connection.prepareStatement(query); 
            resultSet = ps.executeQuery();
            if(resultSet.next()) 
            {
                return true;
               
            }
            else
            {
                return false;
            }
        }
            catch (SQLException e) 
            {
          return false;
           
        }       
    }

}

    
    
   
    
