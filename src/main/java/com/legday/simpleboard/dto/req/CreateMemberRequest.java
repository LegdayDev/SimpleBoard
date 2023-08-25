package com.legday.simpleboard.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateMemberRequest {
    private String username;
    private String password;
    private String email;
}
