/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miruthula
 */
public class Order implements Serializable {

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    public Order(){}

    

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(double tax_rate) {
        this.tax_rate = tax_rate;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public int getpaid() {
        return paid;
    }

    public void setpaid(int paid) {
        this.paid = paid;
    }
    private int order_number;
    private ArrayList<OrderItem> items;
    private String date;
    private User user;
    private int userID;
    private double tax_rate;
    private double total_cost;
    private int paid;
    
    
}
