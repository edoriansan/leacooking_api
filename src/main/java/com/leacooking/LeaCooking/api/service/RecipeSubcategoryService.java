package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
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
    private final RecipeMapper recipeMapper;

    public RecipeSubcategoryDTO saveSubcategory(RecipeSubcategoryDTO subcategoryToSave) {
        RecipeSubcategory recipeSubcategory  = recipeSubcategoryRepository.save(
                recipeSubcategoryMapper.toEntity(subcategoryToSave)
        );
        return recipeSubcategoryMapper.toDTO(recipeSubcategory);
    }

    public List<RecipeSubcategoryDTO> getAllSubcategories() throws ApiException {
        List<RecipeSubcategory> subcategories = recipeSubcategoryRepository.findAll();

        if (subcategories.isEmpty()) {
            throw new ApiException(ErrorEnum.E404, "No subcategories found.");
        }

        return subcategories.stream()
                            .map(recipeSubcategoryMapper::toDTO)
                            .collect(Collectors.toList());
    }

    public RecipeSubcategoryDTO updateSubcategory(Long subcategoryId, RecipeSubcategoryDTO subcategoryToSave) throws ApiException {
        RecipeSubcategory subcategory = recipeSubcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new ApiException(ErrorEnum.E404, "No subcategory not found for id : " + subcategoryId));

        subcategory.setRecipeSubcategoryLabel(subcategoryToSave.getRecipeSubcategoryLabel());
        subcategory.setRecipeSubcategoryImg(subcategoryToSave.getRecipeSubcategoryImg());
        subcategory.setRecipeCategory(subcategoryToSave.getCategory());
        subcategory.setRecipes(
                subcategoryToSave.getRecipes().stream()
                        .map(recipeMapper::toEntity)
                        .collect(Collectors.toSet())
        );

        RecipeSubcategory updatedSubcategory = recipeSubcategoryRepository.save(subcategory);

        return recipeSubcategoryMapper.toDTO(updatedSubcategory);
    }

    public void deleteSubcategoryById(Long subcategoryId) throws ApiException {
        if (!recipeSubcategoryRepository.existsById(subcategoryId)) {
            throw new ApiException(ErrorEnum.E404, "No subcategory not found for id : " + subcategoryId);
        }
        recipeSubcategoryRepository.deleteById(subcategoryId);
    }
}
