package com.huayuan.mms.service;

import com.huayuan.mms.domain.Member;
import com.huayuan.mms.common.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 14-3-20.
 */
public class MemberServiceTest extends BaseTest{

    @Resource
    MemberService memberService;

    @Test
    public void save(){
        Member member = new Member();
        member.setName("dd");
        memberService.register(member);
    }
}
