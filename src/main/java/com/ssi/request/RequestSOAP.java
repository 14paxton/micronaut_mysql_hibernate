package com.ssi.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@Serdeable
@Entity
@Table(name = "request_soap")
public class RequestSOAP {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "soaprequestgen")
    @GenericGenerator(name = "soaprequestgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "wSConfig"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @Nullable
    private String assessmentResultRequestXSLOut;
    @Nullable
    private String binarySecTokenValueType;
    @Nullable
    private String binarySecTokenId;
    @Nullable
    private String binarySecTokenEncodingType;
    @Nullable
    private String wsSecurityPassword;
    @Nullable
    private String wsSecurityUsername;

    @JsonIgnore
    @OneToOne(mappedBy = "soap", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    WSConfig wSConfig;

    public RequestSOAP(@Nullable String assessmentResultRequestXSLOut, @Nullable String binarySecTokenValueType, @Nullable String binarySecTokenId, @Nullable String binarySecTokenEncodingType, @Nullable String wsSecurityPassword, @Nullable String wsSecurityUsername) {
        this.assessmentResultRequestXSLOut = assessmentResultRequestXSLOut;
        this.binarySecTokenValueType = binarySecTokenValueType;
        this.binarySecTokenId = binarySecTokenId;
        this.binarySecTokenEncodingType = binarySecTokenEncodingType;
        this.wsSecurityPassword = wsSecurityPassword;
        this.wsSecurityUsername = wsSecurityUsername;
    }

    public RequestSOAP() {

    }

    public UUID getId() {
        return id;
    }

    public RequestSOAP setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public RequestSOAP setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Nullable
    public String getAssessmentResultRequestXSLOut() {
        return assessmentResultRequestXSLOut;
    }

    public RequestSOAP setAssessmentResultRequestXSLOut(@Nullable String assessmentResultRequestXSLOut) {
        this.assessmentResultRequestXSLOut = assessmentResultRequestXSLOut;
        return this;
    }

    @Nullable
    public String getBinarySecTokenValueType() {
        return binarySecTokenValueType;
    }

    public RequestSOAP setBinarySecTokenValueType(@Nullable String binarySecTokenValueType) {
        this.binarySecTokenValueType = binarySecTokenValueType;
        return this;
    }

    @Nullable
    public String getBinarySecTokenId() {
        return binarySecTokenId;
    }

    public RequestSOAP setBinarySecTokenId(@Nullable String binarySecTokenId) {
        this.binarySecTokenId = binarySecTokenId;
        return this;
    }

    @Nullable
    public String getBinarySecTokenEncodingType() {
        return binarySecTokenEncodingType;
    }

    public RequestSOAP setBinarySecTokenEncodingType(@Nullable String binarySecTokenEncodingType) {
        this.binarySecTokenEncodingType = binarySecTokenEncodingType;
        return this;
    }

    @Nullable
    public String getWsSecurityPassword() {
        return wsSecurityPassword;
    }

    public RequestSOAP setWsSecurityPassword(@Nullable String wsSecurityPassword) {
        this.wsSecurityPassword = wsSecurityPassword;
        return this;
    }

    @Nullable
    public String getWsSecurityUsername() {
        return wsSecurityUsername;
    }

    public RequestSOAP setWsSecurityUsername(@Nullable String wsSecurityUsername) {
        this.wsSecurityUsername = wsSecurityUsername;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "soap", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    public WSConfig getWSConfig() {
        return wSConfig;
    }

    public RequestSOAP setWSConfig(WSConfig wSConfig) {
        this.wSConfig = wSConfig;
        return this;
    }
}