package com.parsa.recipe.category;

import com.parsa.recipe.common.SearchCriteria;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category getById(Long id);
    List<Category> getAll();
    List<Category> search(List<SearchCriteria> searchCriteria);
}
