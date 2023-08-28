package com.legday.simpleboard.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class MemberUpdateResp {
    private int id;
    private String username;
}
