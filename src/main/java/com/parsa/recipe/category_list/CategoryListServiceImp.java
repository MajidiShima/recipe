package com.parsa.recipe.category_list;


import com.parsa.recipe.category.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CategoryListServiceImp  implements ICategoryListService{

    private final CategoryListRepository repository;
    private ICategoryService service;


    @Override
    public CategoryList save(CategoryList categoryList) {

        return repository.save(categoryList);

    }
}
