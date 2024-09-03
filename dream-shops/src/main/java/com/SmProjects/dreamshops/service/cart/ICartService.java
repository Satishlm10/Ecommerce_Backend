package com.SmProjects.dreamshops.service.cart;

import com.SmProjects.dreamshops.dto.CartDto;
import com.SmProjects.dreamshops.model.Cart;
import com.SmProjects.dreamshops.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);


    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);

    CartDto convertToCartDto(Cart cart);
}
