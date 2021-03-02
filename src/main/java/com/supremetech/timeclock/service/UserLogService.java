package com.supremetech.timeclock.service;

import com.supremetech.timeclock.domain.User;
import com.supremetech.timeclock.domain.UserLog;
import com.supremetech.timeclock.domain.UserState;
import com.supremetech.timeclock.repository.UserLogRepository;
import com.supremetech.timeclock.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserLogService {

    private final UserRepository userRepository;
    private final UserLogRepository userLogRepository;

    public UserLogService(UserRepository userRepository, UserLogRepository userLogRepository) {
        this.userRepository = userRepository;
        this.userLogRepository = userLogRepository;
    }

    public UserLog getLatestLogForUser(Long userId) {
        User user = userRepository.getOne(userId);
        return userLogRepository.findTopByUserOrderByCreationDateDesc(user);
    }

    public UserLog addLog(Long userId, UserState state) {
        User user = userRepository.getOne(userId);

        UserLog log = UserLog.builder()
                .user(user)
                .creationDate(LocalDateTime.now())
                .state(state)
                .build();

        return userLogRepository.save(log);
    }

    public List<UserLog> findAll() {
        return userLogRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
    }

    public List<UserLog> getLogsForUser(Long userId) {
        User user = userRepository.getOne(userId);
        return userLogRepository.findAllByUser(user);
    }

}
