package com.parsa.recipe.recipe;


import com.parsa.recipe.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {

    Page<Recipe> findAll(Pageable pageable);
    Page<Recipe> findAll(Specification<Recipe> specification, Pageable pageable);

    List<Recipe> findAll(Specification<Recipe> specification);


}
