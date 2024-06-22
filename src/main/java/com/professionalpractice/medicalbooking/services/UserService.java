package com.professionalpractice.medicalbooking.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.professionalpractice.medicalbooking.dtos.UserDto;
import com.professionalpractice.medicalbooking.dtos.request.UserRequest;

@Service
public interface UserService {
    Page<UserDto> getUsers(PageRequest pageRequest);

    Page<UserDto> getUsersByIsLocked(Boolean status,PageRequest pageRequest);

    UserDto createUser(UserRequest userRequest);

    UserDto getUserById(Long id);

    UserDto getUserByEmail(String email);

    UserDto updateUserProfile(String userEmail, UserRequest userRequest);

    UserDto updateUserById(Long id, UserRequest userRequest);

    UserDto lockUserById(Long id);

    UserDto deleteUserById(Long id);
}
