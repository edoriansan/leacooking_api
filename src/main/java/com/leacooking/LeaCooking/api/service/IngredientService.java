package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.IngredientMapper;
import com.leacooking.LeaCooking.api.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

//    @Transactional(rollbackFor = Exception.class)
//    public Page<IngredientDTO> search(Pageable pageable, Long id, String search) throws ApiException {
//        try {
//            return this.ingredientRepository.search(pageable, id, search)
//                    .map(ingredientMapper::toDTO);
//        } catch (Exception e) {
//            throw new ApiException(e, ErrorEnum.E500);
//        }
//    }

    @Transactional(rollbackFor = Exception.class)
    public Page<IngredientDTO> search(Pageable pageable,  String search) throws ApiException {
        try {
            return this.ingredientRepository.searchLight(pageable, search)
                    .map(ingredientMapper::toDTO);
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }

//    public List<IngredientDTO> getAllIngredientsByRecipe(Long recipeId) throws ApiException {
//        try {
//            return this.ingredientRepository.findByRecipeId(recipeId).stream().map(ingredientMapper::toDTO).toList();
//        } catch (Exception e) {
//            throw new ApiException(e, ErrorEnum.E500);
//        }
//    }
}
