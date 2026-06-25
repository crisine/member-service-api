package com.labs.memberservice;

import com.labs.memberservice.repository.MemberRepository;
import com.labs.memberservice.repository.MemoryMemberRepository;
import com.labs.memberservice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
