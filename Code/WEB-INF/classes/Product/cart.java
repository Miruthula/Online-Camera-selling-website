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
public class cart implements Serializable 
{
    private ArrayList<OrderItem> items;
    public cart()
    {
        items=new ArrayList<OrderItem>();
    }
    public ArrayList<OrderItem> getItems()
    {
        return items;
    }
    
    public void addItem(OrderItem item)
    {
        String code= item.getProduct().getProduct_Code();
        int quantity=item.getQuantity();
        for(int i=0; i<items.size();i++)
        {
            OrderItem orderitem= items.get(i);
            if(orderitem.getProduct().getProduct_Code().equals(code))
            {
                orderitem.setQuantity(quantity);
                return;
            }
        }
      items.add(item);
    }
    
    public void removeitem(OrderItem item)
    {
        String code= item.getProduct().getProduct_Code();
        for(int i=0; i<items.size();i++)
        {
            OrderItem orderitem= items.get(i);
            if(orderitem.getProduct().getProduct_Code().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
    
    public void emptycart()
    {
        items.clear();
    }
}
