/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;

import enitiy.Products;
import java.util.HashMap;

/**
 *
 * @author Mark
 */
public class Cart {
    HashMap<String, Products> cartItems;
    public Cart(){
     cartItems = new HashMap<>();
      
    }
    public HashMap getCartItems(){
        return cartItems;
    }
    public void addToCart(String itemId, Products product){
        cartItems.put(itemId, product);
    } 
    public void removeAll(){
        this.cartItems.clear();
    }
}
