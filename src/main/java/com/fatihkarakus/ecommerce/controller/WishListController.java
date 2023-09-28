package com.fatihkarakus.ecommerce.controller;

import com.fatihkarakus.ecommerce.common.ApiResponse;
import com.fatihkarakus.ecommerce.dto.ProductDto;
import com.fatihkarakus.ecommerce.model.Product;
import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.model.WishList;
import com.fatihkarakus.ecommerce.service.AuthenticationService;
import com.fatihkarakus.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToWishList(@RequestBody Product product, @RequestParam("token") String token) {
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        WishList wishList = new WishList(user, product);

        wishListService.createWishList(wishList);

        ApiResponse apiResponse = new ApiResponse(true,"Added to wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        final List<ProductDto> productDtos = wishListService.getWishListForUser(user);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
