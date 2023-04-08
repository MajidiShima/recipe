package com.parsa.recipe.category_list;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryListRepository extends PagingAndSortingRepository<CategoryList,Long>, JpaSpecificationExecutor<CategoryList> {



}
