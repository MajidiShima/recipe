package com.parsa.recipe.ingredient;


import com.parsa.recipe.common.PagingData;
import com.parsa.recipe.common.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ingredient/")
@AllArgsConstructor

public class IngredientController {

    private final IIngredientService service;
    private IngredientMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody IngredientDTO ingredientDTO) {
        Ingredient ingredient = mapper.toIngredient(ingredientDTO);
        service.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Timed("user.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<IngredientDTO>> getAll() {
        List<Ingredient> ingredients = service.getAll();
        List<IngredientDTO> ingredientDTOS = mapper.TOIngredientDTOList(ingredients);
        return ResponseEntity.ok(ingredientDTOS);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<IngredientDTO>> paging(@PathVariable Integer page, @PathVariable Integer size) {

        Page<Ingredient> userPage = service.paging(page, size);
        int totalPage = userPage.getTotalPages();
        List<Ingredient> data = userPage.getContent();
        List<IngredientDTO> ingredientDTOList = mapper.TOIngredientDTOList(data);
        PagingData<IngredientDTO> pagingData = new PagingData<>(totalPage, page, ingredientDTOList);
        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<IngredientDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {

        List<Ingredient> ingredients = service.search(searchCriteria);
        List<IngredientDTO> userDTOS = mapper.TOIngredientDTOList(ingredients);
        return ResponseEntity.ok(userDTOS);
    }

}
