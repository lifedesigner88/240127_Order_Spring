package com.encore.oreder.member.controller;

import com.encore.oreder.member.dto.MemberCreateReqDto;
import com.encore.oreder.member.dto.MemberCreateResDto;
import com.encore.oreder.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {

    private final MemberService service;
    public MemberController(@Autowired MemberService service) {
        this.service = service;
    }

    @PostMapping("new")
        public MemberCreateResDto createMember(@RequestBody MemberCreateReqDto dto) {
        return service.createMember(dto);
    }
}
