package com.legday.simpleboard.service;

import com.legday.simpleboard.domain.Member;
import com.legday.simpleboard.dto.MemberUpdateDto;
import com.legday.simpleboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public int join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Member findById(int memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void update(int memberId, MemberUpdateDto memberUpdateDto){
        Member findMember = memberRepository.findById(memberId);
        findMember.updateMember(memberUpdateDto);
    }

    public void delete(Member member){
        memberRepository.delete(member);
    }
}
