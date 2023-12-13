package com.supermart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponce implements Serializable {

    public boolean success = true;
    private Object result;
    private RestError error;

    public RestResponce(boolean success){
        this.success = success;
    }

    public RestResponce(boolean success, Object result){
        this.success = success;
        this.result = result;
    }

    public RestResponce(Object body){
        this.result = body;
    }


}
