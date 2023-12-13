package com.supermart.exception;

import lombok.Getter;

import java.util.Map;

public class NotFoundException extends BaseException{
    public NotFoundException(UserNotFound userNotFound) {
        super(404, userNotFound.getStatusCode(), userNotFound.getErrorMessage(), userNotFound.getDeveloperMessage(), userNotFound.getDefaultMessage(), userNotFound.getDefaultMessageParamMap());
    }
    @Getter
    public enum UserNotFound {
        USER_NOT_FOUND("4040100", "User not found", "No User could be found"),
        USER_NOT_FOUND_FOR_EMAIL("4040101", "We appreciate your interest in musajjel.com! If you'd like to try out our platform and provide feedback, please reach out to us at Hello@musajjel.com. Our team will gladly add you to the whitelist. Additionally, feel free to follow our social media channels for updates and more.", "Email not exist"),
        INVALID_USERNAME_PASSWORD("4040103", "Invalid username or password", "Invalid username or password"),
        LINK_NOT_FOUND("4040104", "Link has been expired", "Link has been expired"),
        USER_NOT_FOUND_FOR_ROLE("4040105","User not found for this role" , "User not found for this role");

        private final String statusCode;
        private final String errorMessage;
        private final String developerMessage;
        private String defaultMessage;
        private Map<String, String> defaultMessageParamMap;

        UserNotFound(String statusCode, String errorMessage, String developerMessage) {
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
            this.developerMessage = developerMessage;
        }
    }

}
