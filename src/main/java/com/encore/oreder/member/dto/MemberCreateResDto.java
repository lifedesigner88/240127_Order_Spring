package com.encore.oreder.member.dto;

import com.encore.oreder.member.domain.Member;
import com.encore.oreder.member.domain.Role;
import lombok.Getter;

@Getter
public class MemberCreateResDto {
    private final String name;
    private final String email;
    private final String password;
    private final String adress;
    private final String role;

    public MemberCreateResDto(Member member){
        if (member.getRole().equals(Role.ADMIN)) role = "ADMIN";
        else role = "USER";
        name = member.getName();
        email = member.getEmail();
        password = member.getPassword();
        adress = member.getAdress();
    }

}
