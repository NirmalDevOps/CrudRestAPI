package com.myapp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductRequestDTO {
    @NotBlank(message = "Product name should not be empty or null")
    private String name;
    private String description;

    @NotBlank(message = "ProductType should not be empty or null")
    private String productType;

    @Min(value = 1,message = "quantity is not defined !")
    private int quantity;

    @Min(value = 200, message = "product price can't be less than 200")
    @Max(value = 500000, message = "product price can't be more than 5000")
    private double price;

    private String supplierName;

    private String supplierCode;
}
