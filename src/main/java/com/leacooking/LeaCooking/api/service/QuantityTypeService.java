package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.dto.quantitytype.QuantityTypeDTO;
import com.leacooking.LeaCooking.api.entity.QuantityType;
import com.leacooking.LeaCooking.api.mapper.QuantityTypeMapper;
import com.leacooking.LeaCooking.api.repository.QuantityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuantityTypeService {

    private final QuantityTypeRepository quantityTypeRepository;
    private final QuantityTypeMapper quantityTypeMapper;

    public List<QuantityTypeDTO> getAllQuantityTypes() {
        List<QuantityType> quantityTypes = quantityTypeRepository.findAll();
        return quantityTypes.stream()
                            .map(quantityTypeMapper::toDTO)
                            .collect(Collectors.toList());
    }
}
