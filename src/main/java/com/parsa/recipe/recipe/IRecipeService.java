package com.parsa.recipe.recipe;

import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.user.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRecipeService {

    Recipe save(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Long id);
    Recipe getById(Long id);
    List<Recipe> getAll();
    Page<Recipe> paging(Integer page, Integer size);
    List<Recipe> search(List<SearchCriteria> searchCriteria);

}
