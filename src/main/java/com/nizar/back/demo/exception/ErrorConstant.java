package com.nizar.back.demo.exception;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ErrorConstant {


    private ErrorConstant() {
    }

    public static final Map<String, String> ERROR_CODE_AND_MESSAGE_MAP = new HashMap<>();

    public static final String REQUIRED_FIELD = "Parametre obligatoire";
    public static final String UNKNOWN_FIELD = "Identifiant en entée inconnu";

    static {
        Arrays.stream(ErrorEnum.values()).forEach(errorEnum -> ERROR_CODE_AND_MESSAGE_MAP.put(errorEnum.code, errorEnum.msg));
    }

    @AllArgsConstructor
    private enum ErrorEnum {
        REQUIRED_FIELD(ErrorConstant.REQUIRED_FIELD, "001"),
        UNKNOWN_FIELD(ErrorConstant.UNKNOWN_FIELD, "002");

        final String code;
        final String msg;
    }
}
