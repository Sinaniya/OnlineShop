package com.example.demo.mappings;


import com.example.demo.model.User;
import com.example.demo.model.requests.user.UserRegistrationRequestDto;
import com.example.demo.model.resource.UserDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//what about the Basket?
@Mapper(uses = {OrderMapper.class, BasketMapper.class})
public interface UserMapper {

    @Mapping(source = "userName", target = "name")
    UserDto toUserDto(User user);

    @InheritConfiguration
    List<UserDto> toUsersDto(List<User> users);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);

    @InheritInverseConfiguration
    List<User> toUsers(List<UserDto> userDtoList);

    @Mapping(source = "username", target="userName")
    User toUser(UserRegistrationRequestDto registrationRequestDto);

}
