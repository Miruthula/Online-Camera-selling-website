/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Product;
import java.io.Serializable;
import java.text.NumberFormat;



/**
 *
 * @author Miruthula
 */
public class Product implements Serializable
{

    

    public String getProduct_Code() {
        return product_Code;
    }

    public void setProduct_Code(String product_Code) {
        this.product_Code = product_Code;
    }

    public Product(String product_Code, String product_Name, String catalog_Category, double price,String description, String image) {
        this.product_Code = product_Code;
        this.product_Name = product_Name;
        this.catalog_Category = catalog_Category;
        this.description = description;
        this.price = price;
        this.image = image;
        
    }

       
   

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getCatalog_Category() {
        return catalog_Category;
    }

    public void setCatalog_Category(String catalog_Category) {
        this.catalog_Category = catalog_Category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    private String product_Name;
    private String catalog_Category;
    private String description;
    private double price;
    private String image;
    private String product_Code;

       
public Product() { }


/*public String getImageURL(int Product_Code)
{
   String imageURL = " " + Product_Code + "_item.jpg";   
    return imageURL;
}*/

    

}  