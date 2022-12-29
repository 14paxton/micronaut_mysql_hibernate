package com.ssi.Enums;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public enum HTTPSendType {
    GET("GET"),
    POST("POST"),
    ICIMSPATCH("ICIMSPATCH"),
    PATCH("PATCH"),
    TBE("TBE"),
    CSOD("CSOD"),
    CERIDIAN("CERIDIAN"),
    UKG("UKG");
    private final String code;

    HTTPSendType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return getCode();
    }
}