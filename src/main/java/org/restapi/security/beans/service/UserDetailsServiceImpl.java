package org.restapi.security.beans.service;

import lombok.RequiredArgsConstructor;
import org.restapi.entities.User;
import org.restapi.repo.UserRepository;
import org.restapi.security.beans.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        UserDetailsImpl userDetails = null;

        user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        userDetails = new UserDetailsImpl(user.getPassword(), user.getUsername(),
                user.getSystemUserId(), user.getStatus(), user.getRole().getName());
        return userDetails;
    }
}
