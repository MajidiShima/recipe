package com.parsa.recipe.recipe;


import com.parsa.recipe.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {UserMapper.class})
public interface RecipeMapper {

    Recipe toRecipe(RecipeDTO recipeDTO);
    RecipeDTO toRecipeDTO(Recipe recipe);
    List<Recipe> toRecipeList(List<RecipeDTO> recipeDTOList);
    List<RecipeDTO> TORecipeDTOList(List<Recipe> recipeList);

}
