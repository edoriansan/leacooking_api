package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import com.leacooking.LeaCooking.api.exception.ApiException;
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

    public List<RecipeSubcategoryDTO> getAllSubcategories() throws ApiException {
        List<RecipeSubcategory> subcategories = recipeSubcategoryRepository.findAll();

        if (subcategories.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No subcategories found.");
        }

        return subcategories.stream()
                            .map(recipeSubcategoryMapper::toDTO)
                            .collect(Collectors.toList());
    }
}
