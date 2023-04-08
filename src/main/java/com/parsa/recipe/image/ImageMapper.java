package com.parsa.recipe.image;


import com.parsa.recipe.ingredient.Ingredient;
import com.parsa.recipe.ingredient.IngredientDTO;
import com.parsa.recipe.recipe.RecipeMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {RecipeMapper.class})
public interface ImageMapper {


    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImageList(List<ImageDTO> imageDTOList);
    List<ImageDTO> toImageDTOList(List<Image> imageList);




}
