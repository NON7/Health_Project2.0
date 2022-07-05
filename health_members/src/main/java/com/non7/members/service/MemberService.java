package com.non7.members.service;

import com.non7.common.pojo.Member;

import java.util.List;

public interface MemberService {
//    根据手机号查询会员
    public  Member findByTelephone(String telephone);
    public void add(Member member);
    public List<Integer> findMemberCountByMonths(List<String> months);


}
