
package com.f1soft.task.assigner.request.dto;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

/**
 *
 * @author sunita.joshi
 */
public class ErrorResponse implements Serializable {

    private int responseCode;
    private HttpStatus responseStatus;
    private String errorMsg;
    private String developerMsg;

    public ErrorResponse() {

    }

    public ErrorResponse(int responseCode, HttpStatus status, String errorMsg, String developerMsg) {
        this.responseCode = responseCode;
        this.responseStatus = status;
        this.errorMsg = errorMsg;
        this.developerMsg = developerMsg;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDeveloperMsg() {
        return developerMsg;
    }

    public void setDeveloperMsg(String developerMsg) {
        this.developerMsg = developerMsg;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
