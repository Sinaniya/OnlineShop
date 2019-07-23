package com.example.demo.mappings;


import com.example.demo.model.User;
import com.example.demo.model.resource.UserDto;
import org.mapstruct.Mapper;

import java.util.List;
//what about the Basket?
@Mapper(uses=OrderMapper.class)
public interface UserMapper {
    UserDto toUserDto(User user);
    List<UserDto> toUsersDto(List<User> users);
    User toUser(UserDto userDto);
    List<User> toUsers(List<UserDto> userDtoList);

}
