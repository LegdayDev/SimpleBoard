package com.legday.simpleboard.dto.req;

import com.legday.simpleboard.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateBoardDto {
    private String title;
    private String content;
    //private int memberId;
}
