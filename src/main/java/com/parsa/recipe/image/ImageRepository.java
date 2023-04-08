package com.parsa.recipe.image;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {



}
