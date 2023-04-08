package com.parsa.recipe.image;


import com.parsa.recipe.recipe.IRecipeService;
import com.parsa.recipe.recipe.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImp implements IImageService {

    private final ImageRepository repository;
    private IRecipeService service;


    @Override
    public Image save(Image image) {
        Long recId = image.getRecipe().getId();
        Recipe recipe = service.getById(recId);
        image.setRecipe(recipe);

        return repository.save(image);
    }
}
