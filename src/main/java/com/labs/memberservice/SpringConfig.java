package com.labs.memberservice;

import com.labs.memberservice.repository.JdbcMemberRepository;
import com.labs.memberservice.repository.JdbcTemplateMemberRepository;
import com.labs.memberservice.repository.MemberRepository;
import com.labs.memberservice.repository.MemoryMemberRepository;
import com.labs.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
