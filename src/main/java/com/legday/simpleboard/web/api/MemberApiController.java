package com.legday.simpleboard.web.api;

import com.legday.simpleboard.domain.Member;
import com.legday.simpleboard.dto.req.CreateMemberRequest;
import com.legday.simpleboard.dto.res.RespDto;
import com.legday.simpleboard.service.MemberService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 회원등록 API
     * 스프링 MVC 2편 강의 완강 후에 추가
     */
    @PostMapping("/api/members")
    public RespDto<CreateMemberRequest> createMember(@RequestBody CreateMemberRequest request){
        Member member = new Member();
        member.setUsername(request.getUsername());
        member.setPassword(request.getPassword());
        member.setEmail(request.getEmail());

        int memberId = memberService.join(member);
        return new RespDto<CreateMemberRequest>(HttpStatus.OK,"성공",request);

    }

}

