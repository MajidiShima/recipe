package com.parsa.recipe.user;

import java.util.List;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface UserMapper {

User toUser(UserDTO userDTO);
UserDTO toUserDTO(User user);
List<User> toUserList(List<UserDTO> userDTOList);
List<UserDTO> TOUserDTOList(List<User> userList);



}
