package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipecategory.RecipeCategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeCategoryMapper;
import com.leacooking.LeaCooking.api.repository.RecipeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeCategoryService {

    private final RecipeCategoryRepository recipeCategoryRepository;
    private final RecipeCategoryMapper recipeCategoryMapper;

    public List<RecipeCategoryDTO> getAllCategories() throws ApiException {
        List<RecipeCategory> categories = recipeCategoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No categories found.");
        }

        return categories.stream()
                         .map(recipeCategoryMapper::toDTO)
                         .collect(Collectors.toList());
    }
}
