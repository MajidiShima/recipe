package com.parsa.recipe.category_list;


import com.parsa.recipe.category.Category;
import com.parsa.recipe.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class CategoryListDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = true)
    private String title;
    @ApiModelProperty(required = true, hidden = true)
    private Category category;


}
