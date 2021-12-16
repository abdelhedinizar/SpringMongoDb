package com.nizar.back.demo.controller.cont.user;

import com.nizar.back.demo.doc.EnableSwaggerDocForExternalEndpoint;
import com.nizar.back.demo.dto.input.user.SetUserInputDto;
import com.nizar.back.demo.dto.input.user.UserInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.user.UserOutputDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

@Api(value = "UserService", produces = "application/json", tags = {"User"})
public interface UserController {

    @ApiOperation(value = "User web Service", notes = "", response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    @EnableSwaggerDocForExternalEndpoint
    ResponseEntity<PaginationResultOutputDto<UserOutputDto>> getUsers(UserInputDto inputDto);

    @ApiOperation(value = "Product web Service", notes = "", response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    ResponseEntity<GenericOutputDto> addUsers(@ApiParam("Product to add. Cannot null or empty.") SetUserInputDto setUserInputDto) throws URISyntaxException;

}
