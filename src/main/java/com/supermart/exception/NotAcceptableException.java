package com.supermart.exception;

import lombok.Getter;

import java.util.Map;

public class NotAcceptableException extends BaseException{
    public NotAcceptableException(NotAcceptableExceptionMSG notAcceptableExceptionMSG) {
        super(406, notAcceptableExceptionMSG.getStatusCode(), notAcceptableExceptionMSG.getErrorMessage(),
                notAcceptableExceptionMSG.getDeveloperMessage(), null, null);
    }

    @Getter
    public enum NotAcceptableExceptionMSG {
        PASSWORD_DOES_NOT_MATCH("4060001", "Password does not match.", "Password does not match."),
        USER_TOKEN_IS_EXPIRED("4060002", "User token is expired.", "User token is expired."),
        CAN_NOT_DELETE_LAST_ADMIN("4060003", "Cannot delete last admin.", "Cannot delete last admin."),
        ACCESS_NOT_ALLOWED("4030001", "Access Not Allowed", "Access Not Allowed"),
        ONLY_ADMIN_LOGIN_ALLOWED("4060005", "Only admin is allowed for login.", "Only admin is allowed for login."),
        INVITATION_ALREADY_ACCEPTED("4060006", "Invitation already accepted.", "Invitation already accepted."),
        INVITATION_ALLOWED_TO_PODCASTER("4060007", "Send invitation is allowed to only podcaster.", "Send invitation is allowed to only podcaster."),
        INVITATION_NOT_ACCEPTED("4060008", "Please accept invitation first.", "Please accept invitation first."),
        ACCOUNT_IS_NOT_ACTIVATED("4060009", "Your account is not activated. Please check your email for invitation mail.", "Your account is not activated. Please check your email for invitation mail."),
        USER_IS_NOT_PODCASTER("4060010", "Selected user is not podcaster.", "Selected user is not podcaster."),
        FILE_UPLOAD_IS_REQUIRED("4060011", "Please upload file.", "Please upload file."),
        ACCOUNT_IS_NOT_BLOCKED("4060012", "Account is not blocked", "Account is not blocked"),
        CAN_NOT_BLOCK_SELF("4060013", "Cannot block self", "Cannot block self"),
        INVALID_EPISODE_STATUS("4060014", "Invalid episode status", "Invalid episode status"),
        ACCOUNT_IS_BLOCKED("4060015", "Your account has been suspended. Please contact administrator", "Your account has been suspended. Please contact administrator"),
        INVALID_SLUG_URL("4060016", "Invalid slug URL", "Invalid slug URL"),
        INVALID_ACCESS_TOKEN("406017", "Invalid access Token", "Invalid access token"),
        NOT_SUPPORTED("406018", "Not supported", "Not supported"),
        PODCAST_IS_PUBLISHED("406023","Podcast is already published, you can't change the status of podcast","Podcast is already published, you can't change the status of podcast"),
        EPISODE_IS_PUBLISHED("406024","Episode is already published, you can't change the status of episode","Episode is already published, you can't change the status of episode"),
        INVALID_START_END_DATE("406025","Invalid Start date or End Date","Invalid Start date or End Date"),
        USER_ALREADY_EXIST("406026","User already exist","User already exist"),
        MOBILE_INVALID("406027", "Mobile is not valid", "Mobile is not valid"),
        FIELD_NOT_PRESENT("406028", "Field is mandatory", "Field is mandatory");

        private final String statusCode;
        private final String errorMessage;
        private final String developerMessage;
        private String defaultMessage;
        private Map<String, String> defaultMessageParamMap;

        NotAcceptableExceptionMSG(String statusCode, String errorMessage, String developerMessage) {
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
            this.developerMessage = developerMessage;
        }
    }

}
