package com.legday.simpleboard.web.api;

import com.legday.simpleboard.domain.Board;
import com.legday.simpleboard.dto.req.CreateBoardDto;
import com.legday.simpleboard.dto.req.UpdateBoardDto;
import com.legday.simpleboard.dto.res.BoardRespDto;
import com.legday.simpleboard.dto.res.RespDto;
import com.legday.simpleboard.service.BoardService;
import com.legday.simpleboard.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final MemberService memberService;

    /**
     * Board 생성 로직
     * title, content 를 받는다
     * 로그인 기능을 구현안헀으니 당연히 memberId 롤 모른다
     * session 을 이용하여 로그인 되어있는 Member 의 id 값을 알아야함.
     */
    @PostMapping("/api/board")
    public RespDto<BoardRespDto> write(@RequestBody CreateBoardDto createBoardDto){
        Board board = new Board();
        board.createToBoard(createBoardDto);
        int boardId = boardService.write(board);

        return new RespDto<BoardRespDto>(HttpStatus.OK,"글 등록성공",new BoardRespDto(boardId, createBoardDto.getTitle(), createBoardDto.getContent()));
    }

    /**
     * Board 단건 조회
     * boardId 를 이용하여 게시물을 조회한다.
     */
    @GetMapping("/api/board/{boardId}")
    public RespDto<?> findById(@PathVariable int boardId){
        Board findBoard = boardService.findById(boardId);

        return new RespDto<BoardRespDto>(HttpStatus.OK,"글 조회성공",new BoardRespDto(boardId, findBoard.getTitle(), findBoard.getContent()));
    }

    /**
     * Board 전체 조회
     * Board 의 리스트를 RespDto<> 에 담아야함.
     */
    @GetMapping("/api/boards")
    public RespDto<List> findAll(){
        List<Board> boards = boardService.findAll();
        List<BoardRespDto> collect = boards.stream()
                .map(m -> new BoardRespDto(m.getId(), m.getTitle(), m.getContent()))
                .collect(Collectors.toList());

        return new RespDto<>(HttpStatus.OK,"조회성공",collect);
    }

    /**
     * Board 수정
     * 변경할 boardID와 새로운 title , content 를 DTO 로 받아서 수정한다.
     */
    @PatchMapping("/api/board/{boardId}")
    public RespDto<?> update(@PathVariable int boardId, @RequestBody UpdateBoardDto updateBoardDto){
        boardService.update(boardId,updateBoardDto);

        return new RespDto<BoardRespDto>(HttpStatus.OK,"글 수정 성공", new BoardRespDto(boardId, updateBoardDto.getTitle(), updateBoardDto.getContent()));
    }

    /**
     * Board 삭제
     * boardId 를 받아서 board 객체를 찾아 삭제
     */
    @DeleteMapping("/api/board/{boardId}")
    public RespDto<?> delete(@PathVariable int boardId){
        boardService.delete(boardId);
        return new RespDto<>(HttpStatus.OK,"삭제성공",null);
    }
}
