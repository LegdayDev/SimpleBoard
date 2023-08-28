package com.legday.simpleboard.web.api;

import com.legday.simpleboard.domain.Member;
import com.legday.simpleboard.dto.req.CreateMemberRequest;
import com.legday.simpleboard.dto.req.MemberUpdateDto;
import com.legday.simpleboard.dto.res.MemberListDto;
import com.legday.simpleboard.dto.res.MemberUpdateResp;
import com.legday.simpleboard.dto.res.RespDto;
import com.legday.simpleboard.service.MemberService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

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
        member.setCreatedAt(request.getCreateAt());

        int memberId = memberService.join(member);
        return new RespDto<CreateMemberRequest>(OK,"성공",request);

    }
    /**
     * 회원수정 API
     * username, password 을 DTO 로 받아서 수정
     * 변경된 Member 의 id와 username 을 JSON 으로 반환
     */
    @PatchMapping("/api/members/{memberId}")
    public RespDto<MemberUpdateResp> updateMember(@PathVariable int memberId, @RequestBody MemberUpdateDto request){
        memberService.update(memberId,request);

        return new RespDto<MemberUpdateResp>(OK,"회원수정 성공",new MemberUpdateResp(memberId,request.getUsername()));
    }

    /**
     * 회원단건 조회 API
     * username, email, createdAt 만 보여준다.
     */
    @GetMapping("/api/members/{memberId}")
    public RespDto<MemberListDto> findOne(@PathVariable int memberId){
        Member findMember = memberService.findById(memberId);

        MemberListDto memberDto = new MemberListDto(findMember.getUsername(), findMember.getEmail(), findMember.getCreatedAt());

        return new RespDto<MemberListDto>(OK,"회원 한건 조회 성공", memberDto);

    }

}

