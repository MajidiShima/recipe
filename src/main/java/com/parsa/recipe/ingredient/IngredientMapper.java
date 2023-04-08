package com.parsa.recipe.ingredient;


import com.parsa.recipe.recipe.RecipeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {RecipeMapper.class})
public interface IngredientMapper {


    Ingredient toIngredient( IngredientDTO  ingredientDTO);
    IngredientDTO toIngredientDTO(Ingredient ingredient);
    List<Ingredient> toIngredientList(List<IngredientDTO> ingredientDTOList);
    List<IngredientDTO> TOIngredientDTOList(List<Ingredient> ingredientList);



}
