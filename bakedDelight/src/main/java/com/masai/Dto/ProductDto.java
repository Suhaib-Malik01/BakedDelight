package com.masai.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
   
    private Integer productId;

    private String name;

    private Double price;

    private String description;

    private Integer quntity;

    private String category;

}
