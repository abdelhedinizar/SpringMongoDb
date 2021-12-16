package com.nizar.back.demo.entities.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Countries")
public class Country implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("code")
    private String countryCode;

    @Field("name")
    private String countryName;

}
