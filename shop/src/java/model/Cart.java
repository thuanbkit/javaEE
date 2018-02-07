/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adminis
 */
public class Cart {
    private HashMap<Long,Item> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<Long, Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }
    //insert to card
    public void plusToCart(Long key,Item item) {
        boolean check = cartItems.containsKey(key);
        if(check) {
            int quantity = item.getQuantity();
            item.setQuantity(quantity + 1);
            cartItems.put(key, item);
        } else {
            cartItems.put(key, item);
        }
    }
    // sub to card
    public void subToCart(Long key,Item item) {
        boolean check = cartItems.containsKey(key);
        if(check) {
            int quantity = item.getQuantity();
            if(quantity<=1) {
                cartItems.replace(key, item);
            } else {
                item.setQuantity(quantity-1);
                cartItems.put(key, item);
            }
        } 
    }
    // remove to card
    public void removeToCard(Long key) {
        boolean check = cartItems.containsKey(key);
        if(check) {
            cartItems.remove(key);
        }
    }
    // count item
    public int countItem() {
        int size= cartItems.size();
        return size;
    }
    
    // sum total
    public double totalCart() {
        double total = 0;
        for (Map.Entry<Long, Item> list : cartItems.entrySet()) {
            total += list.getValue().getQuantity() * list.getValue().getProduct().getPrice();
        }
        return total;
        
    }
    
}
