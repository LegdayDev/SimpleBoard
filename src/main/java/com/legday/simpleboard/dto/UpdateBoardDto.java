package com.legday.simpleboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class UpdateBoardDto {
    private String title;
    private String content;
    private LocalDateTime updateAt;
}
