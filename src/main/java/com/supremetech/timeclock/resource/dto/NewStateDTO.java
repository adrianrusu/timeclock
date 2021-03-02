package com.supremetech.timeclock.resource.dto;

import com.supremetech.timeclock.domain.UserState;
import lombok.Data;

@Data
public class NewStateDTO {

    private Long userId;
    private UserState userState;

}
