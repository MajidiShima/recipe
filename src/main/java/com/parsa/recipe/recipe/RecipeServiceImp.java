package com.parsa.recipe.recipe;


import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.common.SearchSpecification;
import com.parsa.recipe.common.exception.NotFoundException;
import com.parsa.recipe.user.IUserService;
import com.parsa.recipe.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeServiceImp implements IRecipeService {

    private final RecipeRepository repository;
    private IUserService userService;



    @Override
    public Recipe save(Recipe recipe) {
        Long userServiceId=recipe.getUser().getId();
        User user=userService.getById(userServiceId);
        recipe.setUser(user);
        return repository.save(recipe);
    }

    @Override
    public Recipe update(Recipe recipe) {
        Recipe lastRecipe=getById(recipe.getId());
        lastRecipe.setCookTime(recipe.getCookTime());
        lastRecipe.setPrepTime(recipe.getPrepTime());
        lastRecipe.setDifficulty(recipe.getDifficulty());
        lastRecipe.setTitle(recipe.getTitle());
        lastRecipe.setNote(recipe.getNote());

        Long userServiceId=recipe.getUser().getId();
        User user1=userService.getById(userServiceId);
        lastRecipe.setUser(user1);

        return repository.save(lastRecipe);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Recipe getById(Long id) {
        Optional<Recipe> optional = repository.findById(id);
        if (!optional.isPresent()){
           throw  new NotFoundException("User Not Found");

    }
        return optional.get();
    }

    @Override
    public List<Recipe> getAll() {
        return (List<Recipe>) repository.findAll();
    }

    @Override
    public Page<Recipe> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }


    // ........................................................lamda is change with ref ........................................
    @Override
    public List<Recipe> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Recipe> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(searchSpecification::add);

        return repository.findAll(searchSpecification);

    }
}
