package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import com.leacooking.LeaCooking.api.mapper.RecipeSubcategoryMapper;
import com.leacooking.LeaCooking.api.repository.RecipeSubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeSubcategoryService {

    private final RecipeSubcategoryRepository recipeSubcategoryRepository;
    private final RecipeSubcategoryMapper recipeSubcategoryMapper;

    public List<RecipeSubcategoryDTO> getAllSubcategories() {
        List<RecipeSubcategory> subcategories = recipeSubcategoryRepository.findAll();
        return subcategories.stream()
                            .map(recipeSubcategoryMapper::toDTO)
                            .collect(Collectors.toList());
    }
}
