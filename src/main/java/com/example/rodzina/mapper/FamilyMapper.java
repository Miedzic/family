package com.example.rodzina.mapper;

import com.example.rodzina.domain.dao.Family;
import com.example.rodzina.domain.dto.FamilyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilyMapper {
    FamilyDto familyToFamilyDto(Family family);

    Family familyDtoToFamily(FamilyDto familyDto);
}
