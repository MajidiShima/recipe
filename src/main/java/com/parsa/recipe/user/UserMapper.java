package com.parsa.recipe.user;

import java.util.List;

public interface UserMapper {

User toUser(UserDTO userDTO);
UserDTO toUserDTO(User user);
List<User> userList(List<User> userList);
List<UserDTO> userDTOList(List<UserDTO> userDTOList);



}
