package com.supermart.validator;

import com.supermart.exception.InvalidEmailException;
import com.supermart.exception.InvalidMobileException;
import com.supermart.module.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BasicValidator {
    @Autowired
    UserRepository userRepository;

    public boolean emailValidate(String email) throws InvalidEmailException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            return true;
        }
        throw new InvalidEmailException("Invalid email format");
    }

    public boolean isemailPresent(String email) throws InvalidEmailException {
        List<String> emailList = userRepository.findAllEmails();
        if(!emailList.contains(email)){
            return true;
        }
        throw new InvalidEmailException("EmailId is already registered... please try with different emailId");
    }

    public boolean mobileValidate(String mobile) throws InvalidMobileException {
        List<String> mobileList = userRepository.findAllMobile();
        if (!mobileList.contains(mobile)){
            return true;
        }
        throw new InvalidMobileException("Mobile number is already registered !!");
    }

}
