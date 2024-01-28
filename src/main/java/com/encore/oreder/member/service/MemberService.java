package com.encore.oreder.member.service;

import com.encore.oreder.member.dto.MemberCreateReqDto;
import com.encore.oreder.member.dto.MemberCreateResDto;
import com.encore.oreder.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
