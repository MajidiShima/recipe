package com.parsa.recipe.category;

import com.parsa.recipe.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDTO  extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private String name;





}
