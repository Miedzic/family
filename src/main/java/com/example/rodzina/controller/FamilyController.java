package com.example.rodzina.controller;

import com.example.rodzina.domain.dto.FamilyDto;
import com.example.rodzina.mapper.FamilyMapper;
import com.example.rodzina.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/families")
@RequiredArgsConstructor
public class FamilyController {
    private final FamilyService familyService;
    private final FamilyMapper familyMapper;

    @GetMapping("/{id}")
    public FamilyDto getFamily(@PathVariable Long id){
        return familyService.getById(id);
    }
    @PostMapping
    public FamilyDto createFamily(@RequestBody FamilyDto familyDto){
            return familyMapper.familyToFamilyDto(familyService.save(familyMapper.familyDtoToFamily(familyDto)));
    }
}
