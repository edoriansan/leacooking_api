package com.leacooking.LeaCooking.service;

import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.IngredientMapper;
import com.leacooking.LeaCooking.api.repository.IngredientRepository;
import com.leacooking.LeaCooking.api.service.IngredientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IngredientServiceTest {

	@Mock
	private IngredientRepository ingredientRepository;

	@Mock
	private IngredientMapper ingredientMapper;

	@InjectMocks
	private IngredientService ingredientService;

	private static final Pageable pageable = PageRequest.of(0, 10);

	@Test
	void oneIngredient() throws ApiException {
		String search = "Sucre";

		// Simuler ingredient
		Ingredient ingredient = new Ingredient();
		ingredient.setLabel("Sucre");

		// Simuler repo
		when(ingredientRepository.searchLight(pageable, search)).thenReturn(new PageImpl<>(Collections.singletonList(ingredient)));
		// Simuler mapper
		when(ingredientMapper.toDTO(ingredient)).thenReturn(IngredientDTO.builder().label("Sucre").build());

		Page<IngredientDTO> ingredients = ingredientService.search(pageable, search);

		assertThat(ingredients.isEmpty()).isFalse();
		assertThat(ingredients.getContent().getFirst().getLabel()).isEqualTo("Sucre");
	}

	@Test
	void allIngredients() throws ApiException {
		String search = "";

		Ingredient ingredient1 = new Ingredient();
		ingredient1.setLabel("Sucre");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setLabel("Sel");
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setLabel("Poivre");

		List<Ingredient> ingredientsList = List.of(ingredient1, ingredient2, ingredient3);

		when(ingredientRepository.searchLight(pageable, search)).thenReturn(new PageImpl<>(ingredientsList));

		when(ingredientMapper.toDTO(ingredient1)).thenReturn(IngredientDTO.builder().label("Sucre").build());
		when(ingredientMapper.toDTO(ingredient2)).thenReturn(IngredientDTO.builder().label("Sel").build());
		when(ingredientMapper.toDTO(ingredient3)).thenReturn(IngredientDTO.builder().label("Poivre").build());

		Page<IngredientDTO> ingredients = ingredientService.search(pageable, search);

		assertThat(ingredients.isEmpty()).isFalse();
		assertThat(ingredients.getTotalElements()).isEqualTo(3);
		assertThat(ingredients.getContent().get(0).getLabel()).isEqualTo("Sucre");
		assertThat(ingredients.getContent().get(1).getLabel()).isEqualTo("Sel");
		assertThat(ingredients.getContent().get(2).getLabel()).isEqualTo("Poivre");
	}
}
