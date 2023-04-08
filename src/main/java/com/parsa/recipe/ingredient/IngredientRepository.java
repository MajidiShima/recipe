package com.parsa.recipe.ingredient;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient,Long> , JpaSpecificationExecutor<Ingredient> {
    Page<Ingredient> findAll(Pageable pageable);


}
