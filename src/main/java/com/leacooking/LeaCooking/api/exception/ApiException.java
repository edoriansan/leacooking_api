package com.leacooking.LeaCooking.api.exception;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import lombok.Getter;

import java.util.Objects;

@Getter
public class ApiException extends Exception {
    private final String code;
    private final ErrorEnum errorEnum;

    private ApiException(Throwable cause, ErrorEnum errorEnum, String message) {
        super(message, cause);
        this.errorEnum = Objects.requireNonNullElse(errorEnum, ErrorEnum.E500);
        this.code = this.errorEnum.name();
    }

    public ApiException(ErrorEnum errorEnum, String message) {
        super(message);
        this.errorEnum = Objects.requireNonNullElse(errorEnum, ErrorEnum.E500);
        this.code = this.errorEnum.name();
    }

    public ApiException(ErrorEnum errorEnum) {
        this(
                errorEnum,
                errorEnum.getDescription()
        );
    }

    public ApiException(ErrorEnum errorEnum, Object... sup) {
        this(
                errorEnum,
                errorEnum.getDescription().formatted(sup)
        );
    }

    public ApiException(Throwable cause, ErrorEnum errorEnum) {
        this(
                cause,
                errorEnum,
                errorEnum.getDescription()
        );
    }

    public ApiException(Throwable cause, ErrorEnum errorEnum, Object... sup) {
        this(
                cause,
                errorEnum,
                errorEnum.getDescription().formatted(sup)
        );
    }
}
