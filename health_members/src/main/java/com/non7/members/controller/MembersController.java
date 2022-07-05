package com.non7.members.controller;

import com.non7.common.pojo.Member;
import com.non7.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/members")
public class MembersController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{telephone}")
    public Member findByTelephone(@PathVariable("telephone") String telephone){
        return memberService.findByTelephone(telephone);
    }

    @PostMapping
    public void add(@RequestBody Member member){
        memberService.add(member);
    }

}
