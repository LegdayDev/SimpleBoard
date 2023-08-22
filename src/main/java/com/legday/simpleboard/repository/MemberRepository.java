package com.legday.simpleboard.repository;

import com.legday.simpleboard.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findById(int memberId){
        return em.find(Member.class,memberId);
    }

    public List<Member> findAll(){
        return em.createQuery("SELECT m FROM Member m",Member.class).getResultList();
    }

    public void delete(Member member){
        em.remove(member);
    }
}
