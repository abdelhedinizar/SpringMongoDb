package com.nizar.back.demo.dto.output.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nizar.back.demo.entities.MyProduct;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductOutputDto implements Serializable {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Price")
    private int price;

    public ProductOutputDto(MyProduct product){
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }
}
