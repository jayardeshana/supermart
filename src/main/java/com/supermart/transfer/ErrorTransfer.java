package com.supermart.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorTransfer {
    private String statusCode;
    private String errorMessage;
    private String developerMessage;
    private String defaultMessage;
    private Map<String, String> defaultMessageParamMap;

}