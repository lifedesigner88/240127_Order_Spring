package com.encore.oreder.member.service;

import com.encore.oreder.member.domain.Member;
import com.encore.oreder.member.dto.MemberCreateReqDto;
import com.encore.oreder.member.dto.MemberCreateResDto;
import com.encore.oreder.member.dto.MemberResDto;
import com.encore.oreder.member.dto.MemberOrderResDto;
import com.encore.oreder.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository repository;
    public MemberService(@Autowired MemberRepository repository) {
        this.repository = repository;
    }

    public MemberCreateResDto createMember(MemberCreateReqDto dto){
        return new MemberCreateResDto(
                repository.save(
                        dto.makeMemberFromReqDto()
                ));
    }

    public List<MemberResDto> getMemberList(){
        return repository.findAll().stream()
                .map(MemberResDto::new)
                .collect(Collectors.toList());
    }

    public List<MemberOrderResDto> getMemberOrderingList(Integer id){
        return repository.findById(id)
                .map(Member::getOrderings)
                .orElse(Collections.emptyList())
                .stream()
                .map(MemberOrderResDto::new)
                .collect(Collectors.toList());
    }


}
