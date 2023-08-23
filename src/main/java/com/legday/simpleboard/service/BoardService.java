package com.legday.simpleboard.service;

import com.legday.simpleboard.domain.Board;
import com.legday.simpleboard.dto.UpdateBoardDto;
import com.legday.simpleboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public int join(Board board){
        boardRepository.save(board);
        return board.getId();
    }

    public Board findById(int boardId){
        return boardRepository.findById(boardId);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public void update(int boardId, UpdateBoardDto boardDto){
        Board findBoard = boardRepository.findById(boardId);
        findBoard.updateToBoard(boardDto);
    }

    public void delete(int boardId){
        Board findBoard = boardRepository.findById(boardId);
        boardRepository.delete(findBoard);
    }
}
