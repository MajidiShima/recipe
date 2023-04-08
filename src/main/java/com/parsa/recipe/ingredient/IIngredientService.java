package com.parsa.recipe.ingredient;

import com.parsa.recipe.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IIngredientService {
    Ingredient save(Ingredient ingredient);
    List<Ingredient> getAll();
    Page<Ingredient> paging(Integer page, Integer size);
    List<Ingredient> search(List<SearchCriteria> searchCriteria);

}
