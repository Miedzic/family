package com.example.rodzina.client;

import com.example.rodzina.domain.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MemberClient {
    private final RestTemplate restTemplate;

    public void saveMember(MemberDto memberDto){
        restTemplate.postForObject("http://localhost:8080/api/members",memberDto,Object.class);
    }
    public List<MemberDto> getMembers(String familyName){
        ResponseEntity<List<MemberDto>> rateReponse =
                restTemplate.exchange("http://localhost:8080/api/members/Lewandowski"
                        , HttpMethod.GET, null, new ParameterizedTypeReference<List<MemberDto>>() {
                        });
        return rateReponse.getBody();
    }
  /*  public List<MemberDto> getMembers(String familyName){
        List<MemberDto> familyName1 = restTemplate.exchange("http://localhost:8080/api/members/Kowalski", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<MemberDto>>() {
        }, Map.of("familyName", familyName)).getBody();
        return familyName1;
    }*/
}
