package com.legday.simpleboard.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateDto {

    private String username;
    private String password;
}
