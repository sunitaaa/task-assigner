
package com.f1soft.task.assigner.exception;

import com.f1soft.task.assigner.request.dto.ErrorResponse;

/**
 *
 * @author sunita.joshi
 */
public class GenericException extends RuntimeException {

    private ErrorResponse errorResponse;

    public GenericException(ErrorResponse errorResponse) {
        super(errorResponse.getErrorMsg());
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
