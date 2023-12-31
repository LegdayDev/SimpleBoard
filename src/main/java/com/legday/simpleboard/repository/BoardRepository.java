package com.legday.simpleboard.repository;

import com.legday.simpleboard.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }
    public Board findById(int boardId){
        return em.find(Board.class, boardId);
    }
    public List<Board> findAll(){
        return em.createQuery("SELECT b FROM Board b").getResultList();
    }
    public void delete(Board board){
        em.remove(board);
    }
}
