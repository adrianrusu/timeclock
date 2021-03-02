package com.supremetech.timeclock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserState {

    ENTRANCE("ENTRANCE"), EXIT("EXIT");

    @Getter
    private final String state;

}
