package com.nizar.back.demo.dto.output.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nizar.back.demo.entities.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserOutputDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("username")
    private String username;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("residenceCountryCode")
    private String residenceCountryCode;
    @JsonProperty("profileCode")
    private String profileCode;

    public UserOutputDto(User user) {
        username = user.getUsername();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        residenceCountryCode = user.getResidenceCountryCode();
        profileCode = user.getProfileCode();
    }
}
