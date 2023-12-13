package com.supermart.module.user.transfer;

import com.supermart.enums.Gender;
import lombok.Data;

@Data
public class SignupRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String mobile;
        private Gender gender;
        private String city;
        private String state;
}
