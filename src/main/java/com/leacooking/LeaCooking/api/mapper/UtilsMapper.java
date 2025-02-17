package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(
        config = MapstructConfig.class
)
public abstract class UtilsMapper {

    // One element to collection mapping

    @Named("toList")
    public <T> List<T> toList(T entity) {
        return List.of(entity);
    }

    @Named("toSet")
    public <T> Set<T> toSet(T entity) {
        return Set.of(entity);
    }
}
