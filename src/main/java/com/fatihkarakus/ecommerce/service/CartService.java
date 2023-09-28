package com.fatihkarakus.ecommerce.service;

import com.fatihkarakus.ecommerce.dto.cart.AddToCartDto;
import com.fatihkarakus.ecommerce.dto.cart.CartDto;
import com.fatihkarakus.ecommerce.dto.cart.CartItemDto;
import com.fatihkarakus.ecommerce.exceptions.CustomException;
import com.fatihkarakus.ecommerce.model.Cart;
import com.fatihkarakus.ecommerce.model.Product;
import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    ProductService productService;
    @Autowired
    CartRepository cartRepository;
    public void addToCart(AddToCartDto addToCartDto, User user) {
        Product product = productService.findById(addToCartDto.getProduct_id());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        cartRepository.save(cart);
    }

    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItems = new ArrayList<>();

        double totalCoast = 0;
        for (Cart cart:cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCoast += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCoast(totalCoast);
        cartDto.setCartItems(cartItems);

        return cartDto;
    }

    public void deleteCartItem(Integer itemId, User user) {
        Optional<Cart> optionalCart = cartRepository.findById(itemId);

        if(optionalCart.isEmpty()) {
            throw new CustomException("cart item id is invalid " +itemId);
        }

        Cart cart = optionalCart.get();

        if(cart.getUser() != user) {
            throw new CustomException("cart item does not belong to user: "+itemId);
        }

        cartRepository.delete(cart);
    }
}
