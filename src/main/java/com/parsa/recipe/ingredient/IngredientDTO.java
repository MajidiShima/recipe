package com.parsa.recipe.ingredient;

import com.parsa.recipe.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private BigDecimal amount;

}
