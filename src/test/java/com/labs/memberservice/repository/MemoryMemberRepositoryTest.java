package com.labs.memberservice.repository;

import com.labs.memberservice.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("misung");

        repository.save(member);

        Member result = repository.findById(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("Member ID not found"));
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("misung1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("misung2");
        repository.save(member2);

        Member result = repository.findByName("misung1")
                        .orElseThrow(() -> new IllegalArgumentException("Member Name not found"));

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("misung1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("misung2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
