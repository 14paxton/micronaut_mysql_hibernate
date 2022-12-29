package com.ssi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssi.Enums.AssessmentReportUrlType;
import com.ssi.integration.Integration;
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@ReflectiveAccess
@Serdeable
@Entity
@GenerateProxy
@Table(name = "client_result")
public class ClientResult {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "clientresultgen")
    @GenericGenerator(name = "clientresultgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "integration"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private ResultREST rest;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private ResultEMAIL email;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private ResultSOAP soap;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private ResultFTP ftp;
    @NonNull
    @Enumerated(EnumType.STRING)
    private AssessmentReportUrlType assessmentReportUrlType;
    @Nullable
    private String endpointURL;
    @NonNull
    private Integer retryCount;
    @NonNull
    private Boolean transformResult;
    @Nullable
    private String assessmentResultXSLOut;
    @NonNull
    private Boolean includeScoringGroupData;
    @Nullable
    private String basicAuthPassword;
    @Nullable
    private String basicAuthUsername;
    @Nullable
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "integration_id")
    @TypeDef(type = DataType.UUID)
    private Integration integration;

    @Creator
    public ClientResult(
            @Nullable ResultREST rest,
            @Nullable ResultEMAIL email,
            @Nullable ResultSOAP soap,
            @Nullable ResultFTP ftp,
            @NonNull AssessmentReportUrlType assessmentReportUrlType,
            @Nullable String endpointURL,
            @NonNull Integer retryCount,
            @NonNull Boolean transformResult,
            @Nullable String assessmentResultXSLOut,
            @NonNull Boolean includeScoringGroupData,
            @Nullable String basicAuthPassword,
            @Nullable String basicAuthUsername,
            @Nullable String description,
            @NonNull Integration integration) {

        if (rest != null) {
            rest.setClientResult(this);
            this.rest = rest;
        }
        if (email != null) {
            email.setClientResult(this);
            this.email = email;
        }
        if (soap != null) {
            soap.setClientResult(this);
            this.soap = soap;
        }
        if (ftp != null) {
            ftp.setClientResult(this);
            this.ftp = ftp;
        }

        this.assessmentReportUrlType = assessmentReportUrlType;
        this.endpointURL = endpointURL;
        this.retryCount = retryCount;
        this.transformResult = transformResult;
        this.assessmentResultXSLOut = assessmentResultXSLOut;
        this.includeScoringGroupData = includeScoringGroupData;
        this.basicAuthPassword = basicAuthPassword;
        this.basicAuthUsername = basicAuthUsername;
        this.description = description;
        this.integration = integration;
    }

    public ClientResult(ClientResultCommand crcCMD, Integration newIntegration) {
        this(
                crcCMD.getRest(),
                crcCMD.getEmail(),
                crcCMD.getSoap(),
                crcCMD.getFtp(),
                crcCMD.getAssessmentReportUrlType(),
                crcCMD.getEndpointURL(),
                crcCMD.getRetryCount(),
                crcCMD.getTransformResult(),
                crcCMD.getAssessmentResultXSLOut(),
                crcCMD.getIncludeScoringGroupData(),
                crcCMD.getBasicAuthPassword(),
                crcCMD.getBasicAuthUsername(),
                crcCMD.getDescription(),
                newIntegration);
    }

    public ClientResult() {

    }

    public UUID getId() {
        return id;
    }

    public ClientResult setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ClientResult setVersion(Long version) {
        this.version = version;
        return this;
    }

    public ResultREST getRest() {
        return rest;
    }

    public ClientResult setRest(ResultREST rest) {
        this.rest = rest;
        return this;
    }

    public ResultEMAIL getEmail() {
        return email;
    }

    public ClientResult setEmail(ResultEMAIL email) {
        this.email = email;
        return this;
    }

    public ResultSOAP getSoap() {
        return soap;
    }

    public ClientResult setSoap(ResultSOAP soap) {
        this.soap = soap;
        return this;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public ResultFTP getFtp() {
        return ftp;
    }

    public ClientResult setFtp(ResultFTP ftp) {
        this.ftp = ftp;
        return this;
    }

    @NonNull
    public AssessmentReportUrlType getAssessmentReportUrlType() {
        return assessmentReportUrlType;
    }

    public ClientResult setAssessmentReportUrlType(@NonNull AssessmentReportUrlType assessmentReportUrlType) {
        this.assessmentReportUrlType = assessmentReportUrlType;
        return this;
    }

    @Nullable
    public String getEndpointURL() {
        return endpointURL;
    }

    public ClientResult setEndpointURL(@Nullable String endpointURL) {
        this.endpointURL = endpointURL;
        return this;
    }

    @NonNull
    public Integer getRetryCount() {
        return retryCount;
    }

    public ClientResult setRetryCount(@NonNull Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    @NonNull
    public Boolean getTransformResult() {
        return transformResult;
    }

    public ClientResult setTransformResult(@NonNull Boolean transformResult) {
        this.transformResult = transformResult;
        return this;
    }

    @Nullable
    public String getAssessmentResultXSLOut() {
        return assessmentResultXSLOut;
    }

    public ClientResult setAssessmentResultXSLOut(@Nullable String assessmentResultXSLOut) {
        this.assessmentResultXSLOut = assessmentResultXSLOut;
        return this;
    }

    @NonNull
    public Boolean getIncludeScoringGroupData() {
        return includeScoringGroupData;
    }

    public ClientResult setIncludeScoringGroupData(@NonNull Boolean includeScoringGroupData) {
        this.includeScoringGroupData = includeScoringGroupData;
        return this;
    }

    @Nullable
    public String getBasicAuthPassword() {
        return basicAuthPassword;
    }

    public ClientResult setBasicAuthPassword(@Nullable String basicAuthPassword) {
        this.basicAuthPassword = basicAuthPassword;
        return this;
    }

    @Nullable
    public String getBasicAuthUsername() {
        return basicAuthUsername;
    }

    public ClientResult setBasicAuthUsername(@Nullable String basicAuthUsername) {
        this.basicAuthUsername = basicAuthUsername;
        return this;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public ClientResult setDescription(@Nullable String description) {
        this.description = description;
        return this;
    }

    public Integration getIntegration() {
        return integration;
    }

    public ClientResult setIntegration(Integration integration) {
        this.integration = integration;
        return this;
    }
}