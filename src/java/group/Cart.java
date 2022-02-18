/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group;

import java.util.HashMap;
import java.util.Map;
import user.UserDTO;

/**
 *
 * @author mac
 */
public class Cart {
    private Map<String, UserDTO> cart;

    public Cart(Map<String, UserDTO> cart) {
        this.cart = cart;
    }

    public Cart() {
    }

    public Map<String, UserDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, UserDTO> cart) {
        this.cart = cart;
    }
    
    public void add(UserDTO user){
        if(this.cart == null){
            this.cart = new HashMap<>();
        }
        if(this.cart.containsKey(user.getUserID())){

        }
        cart.put(user.getUserID(), user);
    }
    
    public void delete(String id){
        if(this.cart == null) return;
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        } 
    }
    
    public void update(UserDTO newUser){
        if(this.cart == null) return;
        if(this.cart.containsKey(newUser.getUserID())){
            this.cart.replace(newUser.getUserID(), newUser);
        }
    }
}
