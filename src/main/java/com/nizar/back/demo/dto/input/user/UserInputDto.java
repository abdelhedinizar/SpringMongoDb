package com.nizar.back.demo.dto.input.user;

import com.nizar.back.demo.dto.input.PaginationInputDto;
import com.nizar.back.demo.sort.user.UserSortBy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserInputDto extends PaginationInputDto {

    public UserInputDto() {
        super(UserSortBy.class);
    }
}
