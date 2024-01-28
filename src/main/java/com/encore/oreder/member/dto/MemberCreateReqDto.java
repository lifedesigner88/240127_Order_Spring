package com.encore.oreder.member.dto;

import com.encore.oreder.member.domain.Member;
import com.encore.oreder.member.domain.Role;
import lombok.Setter;

@Setter
public class MemberCreateReqDto {
    private String name;
    private String email;
    private String password;
    private String adress;
    private String role;

    public Member makeMemberFromReqDto(MemberCreateReqDto this) {
        Role enumRole = Role.ADMIN;  // ADMIN 정확히 일치할 때만
        if (role == null || !role.equals("ADMIN"))
            enumRole = Role.USER;
        return new Member(
            name,
            email,
            password,
            adress,
            enumRole
        );
    }







}
