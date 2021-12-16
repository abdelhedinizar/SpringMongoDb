package com.nizar.back.demo.entities.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "User")
public class User implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("username")
    private String username;

    @Field("firstname")
    private String firstname;

    @Field("lastname")
    private String lastname;

    @Field("residenceCountryCode")
    private String residenceCountryCode;

    @Field("profileCode")
    private String profileCode;

}
