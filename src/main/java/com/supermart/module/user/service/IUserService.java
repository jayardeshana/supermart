package com.supermart.module.user.service;

import com.supermart.exception.InvalidEmailException;
import com.supermart.exception.InvalidMobileException;
import com.supermart.module.user.transfer.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    String createUser(SignupRequest signupRequest) throws InvalidEmailException, InvalidMobileException;
}
