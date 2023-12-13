package com.supermart.module.user.service;

import com.supermart.exception.InvalidEmailException;
import com.supermart.exception.InvalidMobileException;
import com.supermart.module.user.model.User;
import com.supermart.module.user.repository.UserRepository;
import com.supermart.module.user.transfer.SignupRequest;
import com.supermart.validator.BasicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    BasicValidator basicValidator;

    @Autowired
    UserRepository userRepository;
    @Override
    public String createUser(SignupRequest signupRequest) throws InvalidEmailException, InvalidMobileException {
        if (basicValidator.emailValidate(signupRequest.getEmail())
                && basicValidator.isemailPresent(signupRequest.getEmail())
                && basicValidator.mobileValidate(signupRequest.getMobile())
        ){
            User user = new User();
            user.setFirstName(signupRequest.getFirstName());
            user.setLastName(signupRequest.getLastName());
            user.setEmail(signupRequest.getEmail());
            user.setMobile(signupRequest.getMobile());
            user.setCity(signupRequest.getCity());
            user.setGender(signupRequest.getGender());
            user.setState(signupRequest.getState());
            userRepository.save(user);
            return "success";
        }
        return "Fail";
    }
}

