package com.ssi.Enums;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public enum AssessmentReportUrlType {

    REQ_CORE_AUTH("REQ_CORE_AUTH"),
    REQ_AUTH("REQ_AUTH"), //Legacy link required for TB5 Auth
    NO_AUTH("NO_AUTH");
    private final String code;

    AssessmentReportUrlType(String code) {
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