package com.tugsteno.springsecurity.services.impl;

import com.tugsteno.springsecurity.repository.UserRepository;
import com.tugsteno.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /*
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("User not found"));
            }
        };
    }
    */

    public UserDetailsService userDetailsService() throws UsernameNotFoundException{
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(
                        ()-> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
