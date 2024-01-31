package com.encore.oreder.member.controller;

import com.encore.oreder.member.dto.MemberCreateReqDto;
import com.encore.oreder.member.dto.MemberCreateResDto;
import com.encore.oreder.member.dto.MemberResDto;
import com.encore.oreder.member.service.MemberService;
import com.encore.oreder.member.dto.MemberOrderResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private final MemberService service;
    public MemberController(@Autowired MemberService service) {
        this.service = service;
    }

//    Create
    @PostMapping("new")
    public MemberCreateResDto createMember(@RequestBody MemberCreateReqDto dto) {
        return service.createMember(dto);
    }

//    Read
    @GetMapping("list")
    public List<MemberResDto> getMemberList(){
        return service.getMemberList();
    }

    @GetMapping("{id}/orders")
    public List<MemberOrderResDto> getMemberOrderList(@PathVariable Integer id){
        return service.getMemberOrderingList(id);
    }

}
