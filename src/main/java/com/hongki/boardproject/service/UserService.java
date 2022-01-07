package com.hongki.boardproject.service;

import com.hongki.boardproject.domain.user.User;
import com.hongki.boardproject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        return userRepository.save(user).getId();
    }
}
