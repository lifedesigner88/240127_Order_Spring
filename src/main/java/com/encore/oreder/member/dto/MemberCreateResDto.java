package com.encore.oreder.member.dto;

import com.encore.oreder.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberCreateResDto {
    private final String name;
    private final String email;
    private final String password;
    private final String adress;
    private final String role;

    public MemberCreateResDto(Member member){
        this.name = member.getName();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.adress = member.getAdress();
        this.role = member.getRole().toString();
    }
}
