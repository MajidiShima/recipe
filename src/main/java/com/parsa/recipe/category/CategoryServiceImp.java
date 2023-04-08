package com.parsa.recipe.category;

import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.common.SearchSpecification;
import com.parsa.recipe.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements ICategoryService {


    private final CategoryRepository repository;


    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category getById(Long id) {

        Optional<Category> optional=repository.findById(id);
        if(!optional.isPresent()){
            throw new NotFoundException("Category not found");
        }


        return optional.get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public List<Category> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Category> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));
        return repository.findAll(searchSpecification);

    }
}

