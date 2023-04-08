package com.parsa.recipe.category_list;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categoryList")
public class CategoryListController {


    private final ICategoryListService service;
    private final CategoryListMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<CategoryListDTO> save(@RequestBody CategoryListDTO categoryListDTO){
        CategoryList categoryList=mapper.toCategoryLis(categoryListDTO);
        service.save(categoryList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
