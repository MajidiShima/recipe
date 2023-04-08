package com.parsa.recipe.image;

import com.parsa.recipe.common.BaseDTO;
import com.parsa.recipe.recipe.Recipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String images;

    @ApiModelProperty(required = true,hidden = false)
    private Recipe recipe;

}
