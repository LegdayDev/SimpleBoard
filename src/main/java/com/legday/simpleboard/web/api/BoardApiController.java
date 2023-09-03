package com.legday.simpleboard.web.api;

import com.legday.simpleboard.domain.Board;
import com.legday.simpleboard.dto.req.CreateBoardDto;
import com.legday.simpleboard.dto.res.CreateBoardRes;
import com.legday.simpleboard.dto.res.RespDto;
import com.legday.simpleboard.service.BoardService;
import com.legday.simpleboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public RespDto<CreateBoardRes> write(@RequestBody CreateBoardDto createBoardDto){
        Board board = new Board();
        board.createToBoard(createBoardDto);
        int boardId = boardService.write(board);

        return new RespDto<CreateBoardRes>(HttpStatus.OK,"성공",new CreateBoardRes(boardId, createBoardDto.getTitle(), createBoardDto.getContent()));
    }
}
