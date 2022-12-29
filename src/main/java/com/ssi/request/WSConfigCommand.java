package com.ssi.request;

import com.ssi.Enums.CountryCodeFormat;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Requires(classes = CountryCodeFormat.class)
@Serdeable
public class WSConfigCommand {
    @Nullable
    @Valid
    private final RequestREST rest;

    @Nullable
    @Valid
    private final RequestFTP ftp;

    @Nullable
    @Valid
    private final RequestSOAP soap;

    @Nullable
    private final HashMap<String, String> customAORMap;

    @Nullable
    @Valid
    private final CountryCodeFormat countryCodeFormat;

    @Nullable
    private final Boolean allowNoAuth = false;

    @Nullable
    private final Boolean active = true;

    @Nullable
    private final Boolean transformRequestIn;

    @Nullable
    private final Boolean transformRequestResponse;

    @Nullable
    private final Boolean transformStatusIn;

    @Nullable
    private final Boolean transformStatusResponse;

    @Nullable
    private final String assessmentOrderRequestXSLIn;

    @Nullable
    private final String assessmentOrderRequestXSLOut;

    @Nullable
    private final String assessmentStatusRequestXSLIn;

    @Nullable
    private final String assessmentStatusRequestXSLOut;

    @Nullable
    final String description;

     @Creator
    public WSConfigCommand(@Nullable RequestREST rest, @Nullable RequestFTP ftp, @Nullable RequestSOAP soap, @Nullable HashMap<String, String> customAORMap, @Nullable CountryCodeFormat countryCodeFormat, @Nullable Boolean transformRequestIn, @Nullable Boolean transformRequestResponse, @Nullable Boolean transformStatusIn, @Nullable Boolean transformStatusResponse, @Nullable String assessmentOrderRequestXSLIn, @Nullable String assessmentOrderRequestXSLOut, @Nullable String assessmentStatusRequestXSLIn, @Nullable String assessmentStatusRequestXSLOut, @Nullable String description) {
        this.rest = rest;
        this.ftp = ftp;
        this.soap = soap;
        this.customAORMap = customAORMap;
        this.countryCodeFormat = countryCodeFormat;
        this.transformRequestIn = transformRequestIn;
        this.transformRequestResponse = transformRequestResponse;
        this.transformStatusIn = transformStatusIn;
        this.transformStatusResponse = transformStatusResponse;
        this.assessmentOrderRequestXSLIn = assessmentOrderRequestXSLIn;
        this.assessmentOrderRequestXSLOut = assessmentOrderRequestXSLOut;
        this.assessmentStatusRequestXSLIn = assessmentStatusRequestXSLIn;
        this.assessmentStatusRequestXSLOut = assessmentStatusRequestXSLOut;
        this.description = description;
    }

    @Nullable
    public RequestREST getRest() {
        return rest;
    }

    @Nullable
    public RequestFTP getFtp() {
        return ftp;
    }

    @Nullable
    public RequestSOAP getSoap() {
        return soap;
    }

    @Nullable
    public HashMap<String, String> getCustomAORMap() {
        return customAORMap;
    }

    @Nullable
    public CountryCodeFormat getCountryCodeFormat() {
        return countryCodeFormat;
    }

    @Nullable
    public Boolean getAllowNoAuth() {
        return allowNoAuth;
    }

    @Nullable
    public Boolean getActive() {
        return active;
    }

    @Nullable
    public Boolean getTransformRequestIn() {
        return transformRequestIn;
    }

    @Nullable
    public Boolean getTransformRequestResponse() {
        return transformRequestResponse;
    }

    @Nullable
    public Boolean getTransformStatusIn() {
        return transformStatusIn;
    }

    @Nullable
    public Boolean getTransformStatusResponse() {
        return transformStatusResponse;
    }

    @Nullable
    public String getAssessmentOrderRequestXSLIn() {
        return assessmentOrderRequestXSLIn;
    }

    @Nullable
    public String getAssessmentOrderRequestXSLOut() {
        return assessmentOrderRequestXSLOut;
    }

    @Nullable
    public String getAssessmentStatusRequestXSLIn() {
        return assessmentStatusRequestXSLIn;
    }

    @Nullable
    public String getAssessmentStatusRequestXSLOut() {
        return assessmentStatusRequestXSLOut;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
}