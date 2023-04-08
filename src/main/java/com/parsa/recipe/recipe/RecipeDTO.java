package com.parsa.recipe.recipe;

import com.parsa.recipe.common.BaseDTO;
import com.parsa.recipe.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecipeDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private String note;

    @ApiModelProperty(required = true, hidden = false)
    private Integer prepTime;

    @ApiModelProperty(required = true, hidden = false)
    private Integer cookTime;

    @ApiModelProperty(required = true, hidden = false)
    private Difficulty difficulty;

    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

}
