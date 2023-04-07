package com.parsa.recipe.user;

import com.parsa.recipe.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;
    @ApiModelProperty(required = true, hidden = false)
    private String email;
    @ApiModelProperty(required = true, hidden = false)
    private String password;


}
