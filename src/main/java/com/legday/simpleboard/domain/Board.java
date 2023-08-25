package com.legday.simpleboard.domain;

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

    public void updateToBoard(UpdateBoardDto updateDto){
        this.title = updateDto.getTitle();
        this.content = updateDto.getContent();
        this.createdAt = updateDto.getUpdateAt();
    }
}
