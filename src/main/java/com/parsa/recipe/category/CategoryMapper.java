package com.parsa.recipe.category;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDtO(Category category);
    List<Category> toCategoryList(List<CategoryDTO> categoryDTOList);
    List<CategoryDTO> toCategoryDTOList(List<Category> categoryList);


}
