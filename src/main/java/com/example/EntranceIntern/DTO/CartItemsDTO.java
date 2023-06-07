package com.example.EntranceIntern.DTO;

public class CartItemsDTO {

    Integer quantity;
    Long productId;
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CartItemsDTO(Integer quantity, Long productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

   
    
    
}
