package com.wcc.challenge.mapper;

import com.wcc.challenge.dto.GeographicDto;
import com.wcc.challenge.model.Geographic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GeographicToDtoMapper {

    @Mapping(target = "newPostCode", source = "geographic.postcode")
    GeographicDto geographicToDto(Geographic geographic);

}
