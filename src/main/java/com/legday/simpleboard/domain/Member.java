package com.legday.simpleboard.domain;

import com.legday.simpleboard.dto.req.CreateMemberRequest;
import com.legday.simpleboard.dto.req.MemberUpdateDto;
import com.legday.simpleboard.web.api.MemberApiController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter @NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private int id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    private LocalDateTime createdAt;

    public void updateMember(MemberUpdateDto memberUpdateDto){
        this.username =memberUpdateDto.getUsername();
        this.password = memberUpdateDto.getPassword();
    }

    public void createMember(CreateMemberRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
        this.email = request.getEmail();
    }
}
