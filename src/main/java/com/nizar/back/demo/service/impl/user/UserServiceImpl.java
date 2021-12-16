package com.nizar.back.demo.service.impl.user;


import com.google.common.collect.Lists;
import com.nizar.back.demo.dao.user.UserRepo;
import com.nizar.back.demo.dto.enums.GenericStatus;
import com.nizar.back.demo.dto.input.user.SetUserInputDto;
import com.nizar.back.demo.dto.input.user.UserInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.PaginationSummaryOutputDto;
import com.nizar.back.demo.dto.output.user.UserOutputDto;
import com.nizar.back.demo.entities.user.User;
import com.nizar.back.demo.service.user.UserService;
import com.nizar.back.demo.sort.user.UserSortBy;
import com.nizar.back.demo.util.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final int CLAUSE_LIMIT = 1000;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PaginationResultOutputDto<UserOutputDto> getUsers(UserInputDto inputDto) {
        Pageable page = PageableUtils.getPageFromInput(inputDto, UserSortBy.class);
        Page<User> userPage = userRepo.findAll(page);
        List<UserOutputDto> outputDtoList = userPage.stream().map(UserOutputDto::new).collect(Collectors.toList());
        PaginationSummaryOutputDto paginationSummaryOutputDto = new PaginationSummaryOutputDto(userPage);
        return new PaginationResultOutputDto<>(paginationSummaryOutputDto, outputDtoList, "users");
    }

    @Override
    public GenericOutputDto addUsers(SetUserInputDto userInputDto) {
        GenericOutputDto setUserSpecOutput = new GenericOutputDto();
        Set<User> usersToInsert = getUsersToBeInserted(userInputDto);
        deleteExistantUsers(usersToInsert);
        insertUsers(usersToInsert);
        setUserSpecOutput.setResultCode(GenericStatus.OK);
        return setUserSpecOutput;
    }


    private List<User> insertUsers(Set<User> usersToInsert) {
        return userRepo.saveAll(usersToInsert);
    }

    private void deleteExistantUsers(Set<User> users) {
        List<String> usersNames = users.stream().map(user ->
                user.getUsername()).collect(Collectors.toList());
        List<User> usersTodelete = userRepo.findByElement(usersNames, "username", User.class);
        /*     userRepo.findByUsername(usersNames.get(0));  */

        List<List<User>> partsIds = Lists.partition(usersTodelete, CLAUSE_LIMIT);
        for (int i = 0; i < partsIds.size(); i++) {
            userRepo.deleteAll(partsIds.get(i));
        }
    }

    private Set<User> getUsersToBeInserted(SetUserInputDto setUserInputDto) {
        Set<User> users = new HashSet<>();
        setUserInputDto.getUsers().stream().forEach(userDto -> {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setProfileCode(userDto.getProfileCode());
            user.setResidenceCountryCode(userDto.getResidenceCountryCode());
            users.add(user);
        });
        return users;
    }
}
