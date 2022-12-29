package com.ssi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Serdeable
@Entity
@Table(name = "result_soap")
public class ResultSOAP {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "soapresultgen")
    @GenericGenerator(name = "soapresultgen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "clientResult"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @Nullable
    private String wsSecurityUsername;
    @Nullable
    private String wsSecurityPassword;
    @Nullable
    private String soapAction;
    @Nullable
    private String binarySecTokenValueType;
    @Nullable
    private String binarySecTokenEncodingType;
    @Nullable
    private String binarySecTokenId;

    @JsonIgnore
    @OneToOne(mappedBy = "soap", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    ClientResult clientResult;

    public ResultSOAP(@Nullable String wsSecurityUsername, @Nullable String wsSecurityPassword, @Nullable String soapAction, @Nullable String binarySecTokenValueType, @Nullable String binarySecTokenEncodingType, @Nullable String binarySecTokenId) {
        this.wsSecurityUsername = wsSecurityUsername;
        this.wsSecurityPassword = wsSecurityPassword;
        this.soapAction = soapAction;
        this.binarySecTokenValueType = binarySecTokenValueType;
        this.binarySecTokenEncodingType = binarySecTokenEncodingType;
        this.binarySecTokenId = binarySecTokenId;
    }

    public ResultSOAP() {

    }

    public UUID getId() {
        return id;
    }

    public ResultSOAP setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ResultSOAP setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Nullable
    public String getWsSecurityUsername() {
        return wsSecurityUsername;
    }

    public ResultSOAP setWsSecurityUsername(@Nullable String wsSecurityUsername) {
        this.wsSecurityUsername = wsSecurityUsername;
        return this;
    }

    @Nullable
    public String getWsSecurityPassword() {
        return wsSecurityPassword;
    }

    public ResultSOAP setWsSecurityPassword(@Nullable String wsSecurityPassword) {
        this.wsSecurityPassword = wsSecurityPassword;
        return this;
    }

    @Nullable
    public String getSoapAction() {
        return soapAction;
    }

    public ResultSOAP setSoapAction(@Nullable String soapAction) {
        this.soapAction = soapAction;
        return this;
    }

    @Nullable
    public String getBinarySecTokenValueType() {
        return binarySecTokenValueType;
    }

    public ResultSOAP setBinarySecTokenValueType(@Nullable String binarySecTokenValueType) {
        this.binarySecTokenValueType = binarySecTokenValueType;
        return this;
    }

    @Nullable
    public String getBinarySecTokenEncodingType() {
        return binarySecTokenEncodingType;
    }

    public ResultSOAP setBinarySecTokenEncodingType(@Nullable String binarySecTokenEncodingType) {
        this.binarySecTokenEncodingType = binarySecTokenEncodingType;
        return this;
    }

    @Nullable
    public String getBinarySecTokenId() {
        return binarySecTokenId;
    }

    public ResultSOAP setBinarySecTokenId(@Nullable String binarySecTokenId) {
        this.binarySecTokenId = binarySecTokenId;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "soap", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    public ClientResult getClientResult() {
        return clientResult;
    }

    public ResultSOAP setClientResult(ClientResult clientResult) {
        this.clientResult = clientResult;
        return this;
    }
}