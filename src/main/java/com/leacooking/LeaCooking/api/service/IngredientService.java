package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.IngredientMapper;
import com.leacooking.LeaCooking.api.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Transactional(rollbackFor = Exception.class)
    public IngredientDTO saveIngredient(IngredientDTO ingredientToSave) {
        Ingredient ingredient = ingredientRepository.save(
                ingredientMapper.toEntity(ingredientToSave)
        );
        return ingredientMapper.toDTO(ingredient);
    }

    @Transactional(readOnly = true)
    public List<IngredientDTO> getAllIngredients() throws ApiException {
        List<Ingredient> ingredients = ingredientRepository.findAll();

        if (ingredients.isEmpty()) {
            throw new ApiException(ErrorEnum.E404, "No ingredients found");
        }

        return ingredients.stream()
                .map(ingredientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public IngredientDTO updateIngredient(Long ingredientId, IngredientDTO ingredientToSave) throws ApiException {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ApiException(ErrorEnum.E404, "No ingredient not found for id : " + ingredientId));

        ingredientMapper.fromDTO(ingredientToSave, ingredient);

        Ingredient updatedIngredient = ingredientRepository.save(ingredient);

        return ingredientMapper.toDTO(updatedIngredient);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteIngredientById(Long ingredientId) throws ApiException {
        if (!ingredientRepository.existsById(ingredientId)) {
            throw new ApiException(ErrorEnum.E404, "No ingredient not found for id : " + ingredientId);
        }
        ingredientRepository.deleteById(ingredientId);
    }
}