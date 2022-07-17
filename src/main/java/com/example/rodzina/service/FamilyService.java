package com.example.rodzina.service;

import com.example.rodzina.domain.dao.Family;
import com.example.rodzina.domain.dto.FamilyDto;

public interface FamilyService {
    FamilyDto getById(Long id);

    Family save(Family family);
    boolean validateFamilyData(FamilyDto familyDto);
}
