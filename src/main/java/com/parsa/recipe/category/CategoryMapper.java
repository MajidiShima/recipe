package com.parsa.recipe.category;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDtO(Category category);

    List<CategoryDTO> toCategoryDTOList(List<Category> categoryList);


}
