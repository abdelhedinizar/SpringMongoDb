package com.nizar.back.demo.dto.output;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaginationResultOutputDto<T>{

    @JsonProperty("summary")
    private PaginationSummaryOutputDto paginationSummaryOutputDto;

    @JsonIgnore
    @JsonInclude(NON_NULL)
    private List<T> result;

    @JsonIgnore
    private String propertyName;

    @JsonAnyGetter
    public Map<String, Object> serializeResultWithACustomName(){
        if(result != null) {
            return Collections.singletonMap(propertyName,result);
        }
        return null;
    }
}
