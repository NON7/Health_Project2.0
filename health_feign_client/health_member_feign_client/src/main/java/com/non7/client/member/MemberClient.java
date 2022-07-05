package com.non7.client.member;

import com.non7.common.pojo.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("health-members")
public interface MemberClient {
    @GetMapping("/members/{telephone}")
    public Member findByTelephone(@PathVariable("telephone") String telephone);

    @PostMapping("/members")
    public void add(@RequestBody Member member);

}
