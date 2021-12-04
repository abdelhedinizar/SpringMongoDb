package com.nizar.back.demo.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailsDTO {

    @JsonProperty("label")
    private String labelError;

    @JsonProperty("code")
    private String codeError;

    @JsonProperty("field")
    private String field;

    @Override
    public String toString() {
        return "CheckErrorDTO [" +
                "labelError='" + labelError + '\'' +
                ", codeError='" + codeError + '\'' +
                ", field='" + field + '\'' +
                ']';
    }
}
