package com.fatihkarakus.ecommerce.dto.cart;

import jakarta.validation.constraints.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull Integer product_id;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
