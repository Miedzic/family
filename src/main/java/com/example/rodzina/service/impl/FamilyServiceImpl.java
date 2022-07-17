package com.example.rodzina.service.impl;

import com.example.rodzina.client.MemberClient;
import com.example.rodzina.domain.dao.Family;
import com.example.rodzina.domain.dto.FamilyDto;
import com.example.rodzina.domain.dto.MemberDto;
import com.example.rodzina.mapper.FamilyMapper;
import com.example.rodzina.repository.FamilyRepository;
import com.example.rodzina.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {
    private final FamilyRepository familyRepository;
    private final FamilyMapper familyMapper;
    private final MemberClient memberClient;

    @Override
    public FamilyDto getById(final Long id) {
        var xd = familyMapper.familyToFamilyDto(familyRepository.getById(id));
        xd.setFamilyMembers(memberClient.getMembers(familyRepository.getById(id).getFamilyName()));
        return xd;

    }

    @Override
    public Family save(Family family) {
            return familyRepository.save(family);
    }
// działa lista dla tych utworzonych w member
    public boolean validateFamilyData(FamilyDto familyDto) {
        int nrOfAdults = 0;
        int nrOfChildren = 0;
        int nrOfInfants = 0;

        List<MemberDto> list = memberClient.getMembers(familyDto.getFamilyName());
      //  List<MemberDto> list = familyDto.getFamilyMembers()
        System.out.println(list);
        for (final MemberDto memberDto : list) {
            if (memberDto.getAge() >= 0 && memberDto.getAge() < 4) {
                nrOfInfants++;
            } else if (memberDto.getAge() >= 4 && memberDto.getAge() < 16) {
                nrOfChildren++;
            } else if (memberDto.getAge() >= 16) {
                nrOfAdults++;
            }
        }
        if (familyDto.getNrOfAdults() == nrOfAdults && familyDto.getNrOfChildren() == nrOfChildren && familyDto.getNrOfInfants() == nrOfInfants) {
            return true;
        } else return false;
    }
}
