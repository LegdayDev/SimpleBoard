package com.legday.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBoardDto {
    private String title;
    private String content;
}