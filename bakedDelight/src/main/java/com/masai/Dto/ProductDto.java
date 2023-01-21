package com.masai.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
    @Id
    private Integer productId;

    private String name;

    private Double price;

    private String description;

    private Integer quntity;

    private String category;

}
