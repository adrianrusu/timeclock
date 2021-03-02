package com.supremetech.timeclock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_LOGS")
public class UserLog {

    @Id
    @GeneratedValue
    private Long id;

    private UserState state;

    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(updatable = false)
    private User user;

}
