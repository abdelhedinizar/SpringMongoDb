package com.nizar.back.demo.controller.impl.user;

import com.nizar.back.demo.aop.WsLog;
import com.nizar.back.demo.controller.cont.user.UserController;
import com.nizar.back.demo.dto.input.user.SetUserInputDto;
import com.nizar.back.demo.dto.input.user.UserInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.user.UserOutputDto;
import com.nizar.back.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/service")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @Override
    @GetMapping("/users")
    @ResponseBody
    @WsLog(serviceName = "api/dc/users")
    public ResponseEntity<PaginationResultOutputDto<UserOutputDto>> getUsers(UserInputDto inputDto) {
        PaginationResultOutputDto<UserOutputDto> result = userService.getUsers(inputDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    @PostMapping("/users")
    @ResponseBody
    @WsLog(serviceName = "api/dc/users")
    public ResponseEntity<GenericOutputDto> addUsers(@Valid @RequestBody SetUserInputDto userInput) {
        GenericOutputDto result = userService.addUsers(userInput);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
