package com.leacooking.LeaCooking.api.config.mapper;

import com.leacooking.LeaCooking.api.mapper.UtilsMapper;
import com.leacooking.LeaCooking.api.service.utils.EntityReferenceService;
import org.mapstruct.*;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        typeConversionPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UtilsMapper.class, EntityReferenceService.class}
)
public class MapstructConfig {
}

