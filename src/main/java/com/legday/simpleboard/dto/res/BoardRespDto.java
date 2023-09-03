package com.legday.simpleboard.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class BoardRespDto {
    private int boardId;
    private String title;
    private String content;
}
