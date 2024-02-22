package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Userr;

import java.util.List;

public interface CartService {

    List<Cart> getMyCart(Userr user);
    List getMyProducts(String email);
    void addProductMyCart(String email, long id);
    void deleteProductMyCart(String email, long id);

}
