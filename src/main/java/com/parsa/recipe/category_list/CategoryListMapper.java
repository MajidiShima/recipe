package com.parsa.recipe.category_list;


import com.parsa.recipe.category.Category;
import com.parsa.recipe.category.CategoryDTO;
import com.parsa.recipe.category.CategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {CategoryMapper.class})
public interface CategoryListMapper {

    CategoryList toCategoryLis(CategoryListDTO categoryLisDTO);
    CategoryListDTO toCategoryListDtO(CategoryList categoryList);
    List<CategoryListDTO> toCategoryListDTOList(List<CategoryList> categoryList1);


}
