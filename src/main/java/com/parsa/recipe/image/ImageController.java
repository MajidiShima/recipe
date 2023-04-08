package com.parsa.recipe.image;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image/")
@AllArgsConstructor
public class ImageController {


    private final IImageService service;
    private ImageMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<ImageDTO> save(@RequestBody ImageDTO imageDTO){

        Image image=mapper.toImage(imageDTO);
        service.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }




}
