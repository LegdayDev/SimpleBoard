package com.legday.simpleboard.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Getter @Setter
public class UpdateBoardDto {
    private String title;
    private String content;
    private LocalDateTime updateAt;

    @PrePersist
    public void updateAt(){
        this.updateAt = LocalDateTime.now();
    }
}
