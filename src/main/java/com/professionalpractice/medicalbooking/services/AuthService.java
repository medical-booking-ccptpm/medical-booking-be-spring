package com.professionalpractice.medicalbooking.services;

import com.professionalpractice.medicalbooking.dtos.request.LoginRequest;
import com.professionalpractice.medicalbooking.dtos.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest body);

    LoginResponse loginWithToken();
}
