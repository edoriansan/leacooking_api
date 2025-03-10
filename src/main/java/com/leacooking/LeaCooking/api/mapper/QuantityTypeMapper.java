package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.dto.quantitytype.QuantityTypeDTO;
import com.leacooking.LeaCooking.api.entity.QuantityType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuantityTypeMapper {
    QuantityTypeDTO toDTO(QuantityType quantityType);
    QuantityType toEntity(QuantityTypeDTO quantityTypeDTO);
}
