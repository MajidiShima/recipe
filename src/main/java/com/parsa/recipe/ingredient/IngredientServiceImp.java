package com.parsa.recipe.ingredient;


import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.common.SearchSpecification;
import com.parsa.recipe.recipe.IRecipeService;
import com.parsa.recipe.recipe.Recipe;
import com.parsa.recipe.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImp implements IIngredientService {


private final IngredientRepository repository;
private final IRecipeService recipeService;


    @Override
    public Ingredient save(Ingredient ingredient) {

        Long recId=ingredient.getRecipe().getId();
        Recipe recipe=recipeService.getById(recId);
        ingredient.setRecipe(recipe);
        return repository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return (List<Ingredient>) repository.findAll();
    }

    @Override
    public Page<Ingredient> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Ingredient> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Ingredient> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);

    }
}
