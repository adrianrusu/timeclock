package com.supremetech.timeclock.repository;

import com.supremetech.timeclock.domain.User;
import com.supremetech.timeclock.domain.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {

    UserLog findTopByUserOrderByCreationDateDesc(User user);
    List<UserLog> findAllByUser(User user);

}
