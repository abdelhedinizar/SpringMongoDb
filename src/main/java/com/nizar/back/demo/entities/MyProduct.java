package com.nizar.back.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class MyProduct {

    @Id
    private String id;
    private String name;
    private Integer price;
}
