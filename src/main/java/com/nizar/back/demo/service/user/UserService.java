package com.nizar.back.demo.service.user;

import com.nizar.back.demo.dto.input.user.SetUserInputDto;
import com.nizar.back.demo.dto.input.user.UserInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.user.UserOutputDto;
import com.nizar.back.demo.entities.user.User;

import java.util.List;

public interface UserService {
    GenericOutputDto addUsers(SetUserInputDto userInputDto);
    PaginationResultOutputDto<UserOutputDto> getUsers(UserInputDto inputDto);
}
