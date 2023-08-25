package com.legday.simpleboard.service;

import com.legday.simpleboard.domain.Board;
import com.legday.simpleboard.dto.req.UpdateBoardDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired
    EntityManager em;

    @Test
    void 글등록() {
        //given
        Board board = new Board();
        board.setTitle("Cristiano");
        board.setContent("Football King Football King Football King Football King ");
        board.setCreatedAt(LocalDateTime.now());

        //when
        int boardId = boardService.write(board);

        //then
        assertThat(boardId).isEqualTo(board.getId());
    }

    @Test
    void 글_한건_조회() {
        //given
        Board board = new Board();
        board.setTitle("Cristiano");
        board.setContent("Football King Football King Football King Football King ");
        board.setCreatedAt(LocalDateTime.now());

        int boardId = boardService.write(board);

        //when
        Board findBoard = boardService.findById(boardId);

        //then
        assertThat(findBoard.getId()).isEqualTo(board.getId());
    }

    @Test
    void 글_전체_조회() {
        //given
        Board board1 = new Board();
        board1.setTitle("Cristiano");
        board1.setContent("Football King Football King Football King Football King ");
        board1.setCreatedAt(LocalDateTime.now());

        Board board2 = new Board();
        board2.setTitle("Messi");
        board2.setContent("Football good Football good Football good Football good ");
        board2.setCreatedAt(LocalDateTime.now());

        boardService.write(board1);
        boardService.write(board2);

        //when
        List<Board> boards = boardService.findAll();

        //then
        assertThat(boards.size()).isEqualTo(2);
    }

    @Test
    void 글_수정하기() {
        //given
        Board board = new Board();
        board.setTitle("Cristiano");
        board.setContent("Football King Football King Football King Football King ");
        board.setCreatedAt(LocalDateTime.now());
        int boardId = boardService.write(board);

        //when
        boardService.update(boardId,new UpdateBoardDto("Cristiano Ronaldo","Ronaldo World Class King",LocalDateTime.now()));

        Board findBoard = boardService.findById(boardId);

        //then
        assertThat(findBoard.getTitle()).isEqualTo("Cristiano Ronaldo");
        assertThat(findBoard.getContent()).isEqualTo("Ronaldo World Class King");

    }

    @Test
    void delete() {
        //given
        Board board = new Board();
        board.setTitle("Cristiano");
        board.setContent("Football King Football King Football King Football King ");
        board.setCreatedAt(LocalDateTime.now());

        int boardId = boardService.write(board);

        //when
        boardService.delete(boardId);

        //then
        List<Board> boards = boardService.findAll();
        assertThat(boards.size()).isEqualTo(0);
    }
}