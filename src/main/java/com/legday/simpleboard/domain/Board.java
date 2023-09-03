package com.legday.simpleboard.domain;

import com.legday.simpleboard.dto.req.CreateBoardDto;
import com.legday.simpleboard.dto.req.UpdateBoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private int id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private LocalDateTime createdAt;

    @PrePersist
    public void createAt(){
        this.createdAt = LocalDateTime.now();
    }

    public void updateToBoard(UpdateBoardDto updateDto) {
        this.title = updateDto.getTitle();
        this.content = updateDto.getContent();
        this.createdAt = updateDto.getUpdateAt();
    }
    public void createToBoard(CreateBoardDto createBoardDto){
        this.title = createBoardDto.getTitle();
        this.content = createBoardDto.getContent();
        // 추후에 로그인 기능 구현후 memberId 를 가져오자.
    }
}
