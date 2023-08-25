package com.legday.simpleboard.service;

import com.legday.simpleboard.domain.Member;
import com.legday.simpleboard.dto.req.MemberUpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setUsername("Ronaldo");
        member.setPassword("cr7");

        //when
        int memberId = memberService.join(member);

        //then
        assertThat(memberId).isEqualTo(member.getId());
    }

    @Test
    void 회원단건조회() {
        //given
        Member member = new Member();
        member.setUsername("Ronaldo");
        member.setPassword("cr7");

        int memberId = memberService.join(member);

        //when
        Member findMember = memberService.findById(memberId);

        //then
        assertThat(findMember).isSameAs(member);
    }

    @Test
    void 회원전체조회() {
        //given
        Member member1 = new Member();
        member1.setUsername("Ronaldo");
        member1.setPassword("cr7");

        Member member2 = new Member();
        member2.setUsername("Messi");
        member2.setPassword("ms10");

        memberService.join(member1);
        memberService.join(member2);

        //when
        List<Member> members = memberService.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    void 회원정보수정() {
        //given
        Member member = new Member();
        member.setUsername("Ronaldo");
        member.setPassword("cr7");

        int memberId = memberService.join(member);

        //when
        memberService.update(memberId, new MemberUpdateDto("Cristiano","Siuuuu"));

        //then
        assertThat(member.getUsername()).isEqualTo("Cristiano");
    }

    @Test
    void 회원탈퇴(){
        //given
        Member member = new Member();
        member.setUsername("Ronaldo");
        member.setPassword("cr7");

        int memberId = memberService.join(member);

        //when
        memberService.delete(member);

        //then
        List<Member> members = memberService.findAll();

        assertThat(members.size()).isEqualTo(0);

    }
}