package com.parsa.recipe.category;


import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.image.Image;
import com.parsa.recipe.user.User;
import com.parsa.recipe.user.UserDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService service;
    private CategoryMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
        Category category=mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category category = service.getById(id);
        CategoryDTO category1= mapper.toCategoryDtO(category);
        return ResponseEntity.ok(category1);
    }


    @Timed("user.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> categoryList = service.getAll();
        List<CategoryDTO> categoryDTOList = mapper.toCategoryDTOList(categoryList);
        return ResponseEntity.ok(categoryDTOList);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<CategoryDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {

        List<Category> categories=service.search(searchCriteria);
        List<CategoryDTO> categoryDTOS = mapper.toCategoryDTOList(categories);
        return ResponseEntity.ok(categoryDTOS);
    }

}
