package com.parsa.recipe.recipe;


import com.parsa.recipe.common.PagingData;
import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.user.User;
import com.parsa.recipe.user.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipe")
@AllArgsConstructor
public class RecipeController  {
    private final IRecipeService service;
    private RecipeMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<RecipeDTO> save(@RequestBody RecipeDTO recipeDTO){
        Recipe recipe=mapper.toRecipe(recipeDTO);
        service.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<RecipeDTO> update(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe=mapper.toRecipe(recipeDTO);
        service.update(recipe);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<RecipeDTO> getById(@PathVariable Long id) {
       Recipe recipe=service.getById(id);
       RecipeDTO recipeDTO=mapper.toRecipeDTO(recipe);
        return ResponseEntity.ok(recipeDTO);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<RecipeDTO>> paging(@PathVariable Integer page, @PathVariable Integer size) {

        Page<Recipe> userPage = service.paging(page,size);
        int totalPage = userPage.getTotalPages();
        List<Recipe> data = userPage.getContent();
        List<RecipeDTO> recipeDTOSDTOS = mapper.TORecipeDTOList(data);
        PagingData<RecipeDTO> pagingData = new PagingData<>(totalPage, page, recipeDTOSDTOS);
        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<RecipeDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {

        List<Recipe> recipeList =service.search(searchCriteria);
        List<RecipeDTO> recipeDTOS = mapper.TORecipeDTOList(recipeList);
        return ResponseEntity.ok(recipeDTOS);
    }


}
