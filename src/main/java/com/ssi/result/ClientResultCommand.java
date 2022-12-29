package com.ssi.result;

import com.ssi.Enums.AssessmentReportUrlType;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Requires(classes = AssessmentReportUrlType.class)
@Serdeable
@ConfigurationProperties("app.clientResult")
public class ClientResultCommand {
    @Nullable
    @Valid
    private final ResultREST rest;
    @Nullable
    @Valid
    private final ResultEMAIL email;
    @Nullable
    @Valid
    private final ResultSOAP soap;
    @Nullable
    @Valid
    private final ResultFTP ftp;
    @NotNull
    private AssessmentReportUrlType assessmentReportUrlType = AssessmentReportUrlType.REQ_AUTH;;

    @Nullable
    protected final String endpointURL;

    @Min(1)
    @Max(10)
    @NonNull
    private Integer retryCount = 2;

    @NonNull
    private final Boolean transformResult;

    @Nullable
    private final String assessmentResultXSLOut;

    @NonNull
    private final Boolean includeScoringGroupData;

    @Nullable
    private final String basicAuthPassword;

    @Nullable
    private final String basicAuthUsername;

    @Nullable
    private final String description;

    @Creator
    public ClientResultCommand(@Nullable ResultREST rest,
                               @Nullable ResultEMAIL email,
                               @Nullable ResultSOAP soap,
                               @Nullable ResultFTP ftp,
                               @Nullable AssessmentReportUrlType assessmentReportUrlType,
                               @Nullable String endpointURL,
                               @Nullable Integer retryCount,
                               @NonNull Boolean transformResult,
                               @Nullable String assessmentResultXSLOut,
                               @NonNull Boolean includeScoringGroupData,
                               @Nullable String basicAuthPassword,
                               @Nullable String basicAuthUsername,
                               @Nullable String description) {
        this.rest = rest;
        this.email = email;
        this.soap = soap;
        this.ftp = ftp;
        if(assessmentReportUrlType != null){
            this.assessmentReportUrlType = assessmentReportUrlType;
        }
        this.endpointURL = endpointURL;
        if(retryCount != null){
            this.retryCount = retryCount;
        }
        this.transformResult = transformResult;
        this.assessmentResultXSLOut = assessmentResultXSLOut;
        this.includeScoringGroupData = includeScoringGroupData;
        this.basicAuthPassword = basicAuthPassword;
        this.basicAuthUsername = basicAuthUsername;
        this.description = description;
    }

    @Nullable
    public ResultREST getRest() {
        return rest;
    }

    @Nullable
    public ResultEMAIL getEmail() {
        return email;
    }

    @Nullable
    public ResultSOAP getSoap() {
        return soap;
    }

    @Nullable
    public ResultFTP getFtp() {
        return ftp;
    }

    public AssessmentReportUrlType getAssessmentReportUrlType() {
        return assessmentReportUrlType;
    }

    @Nullable
    public String getEndpointURL() {
        return endpointURL;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    @NonNull
    public Boolean getTransformResult() {
        return transformResult;
    }

    @Nullable
    public String getAssessmentResultXSLOut() {
        return assessmentResultXSLOut;
    }

    @NonNull
    public Boolean getIncludeScoringGroupData() {
        return includeScoringGroupData;
    }

    @Nullable
    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    @Nullable
    public String getBasicAuthUsername() {
        return basicAuthUsername;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
}