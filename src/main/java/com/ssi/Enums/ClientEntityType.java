package com.ssi.Enums;

import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public enum ClientEntityType {
    ASMNT_MAP("assessmentCode"),
    CNTRY_MAP("country"),
    STPRV_MAP("state"),
    GNDR_MAP("gender"),
    PHONTYP_MAP("phoneType"),
    LANG_MAP("lang"),
    ETHNIC_MAP("ethnicBackground"),
    VETERAN_MAP("veteran");
    private final String code;

    ClientEntityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name();
    }
}