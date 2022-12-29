package com.ssi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssi.Enums.HTTPSendType;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Version;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Requires(classes = HTTPSendType.class)
@Serdeable
@Entity
@Table(name = "result_rest")
public class ResultREST {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "restresultgen")
    @GenericGenerator(name = "restresultgen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "clientResult"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @NonNull
    @Enumerated(EnumType.STRING)
    private HTTPSendType httpSendMethod;
    @NotBlank
    private String payloadFormat;
    @NotBlank
    private String contentType;

    @JsonIgnore
    @OneToOne(mappedBy = "rest", optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId("id")
    ClientResult clientResult;

    public ResultREST(@NonNull HTTPSendType httpSendMethod, String payloadFormat, String contentType) {
        this.httpSendMethod = httpSendMethod;
        this.payloadFormat = payloadFormat;
        this.contentType = contentType;
    }

    public ResultREST() {

    }

    public UUID getId() {
        return id;
    }

    public ResultREST setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ResultREST setVersion(Long version) {
        this.version = version;
        return this;
    }

    @NonNull
    public HTTPSendType getHttpSendMethod() {
        return httpSendMethod;
    }

    public ResultREST setHttpSendMethod(@NonNull HTTPSendType httpSendMethod) {
        this.httpSendMethod = httpSendMethod;
        return this;
    }

    public String getPayloadFormat() {
        return payloadFormat;
    }

    public ResultREST setPayloadFormat(String payloadFormat) {
        this.payloadFormat = payloadFormat;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public ResultREST setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "rest", optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId("id")
    public ClientResult getClientResult() {
        return clientResult;
    }

    public ResultREST setClientResult(ClientResult clientResult) {
        this.clientResult = clientResult;
        return this;
    }
}