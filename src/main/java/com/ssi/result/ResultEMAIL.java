package com.ssi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Serdeable
@Entity
@Table(name = "result_email")
public class ResultEMAIL {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "emailresultgen")
    @GenericGenerator(name = "emailresultgen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "clientResult"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @NotBlank
    private String subject;
    @NotBlank
    private String toAddressList;
    @Nullable
    private String bodyHeader;
    @Nullable
    private String ccAddressList;

    @JsonIgnore
    @OneToOne(mappedBy = "email", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    ClientResult clientResult;

    public ResultEMAIL(String subject, String toAddressList, @Nullable String bodyHeader, @Nullable String ccAddressList) {
        this.subject = subject;
        this.toAddressList = toAddressList;
        this.bodyHeader = bodyHeader;
        this.ccAddressList = ccAddressList;
    }

    public ResultEMAIL() {

    }

    public UUID getId() {
        return id;
    }

    public ResultEMAIL setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ResultEMAIL setVersion(Long version) {
        this.version = version;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ResultEMAIL setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getToAddressList() {
        return toAddressList;
    }

    public ResultEMAIL setToAddressList(String toAddressList) {
        this.toAddressList = toAddressList;
        return this;
    }

    @Nullable
    public String getBodyHeader() {
        return bodyHeader;
    }

    public ResultEMAIL setBodyHeader(@Nullable String bodyHeader) {
        this.bodyHeader = bodyHeader;
        return this;
    }

    @Nullable
    public String getCcAddressList() {
        return ccAddressList;
    }

    public ResultEMAIL setCcAddressList(@Nullable String ccAddressList) {
        this.ccAddressList = ccAddressList;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "email", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    public ClientResult getClientResult() {
        return clientResult;
    }

    public ResultEMAIL setClientResult(ClientResult clientResult) {
        this.clientResult = clientResult;
        return this;
    }
}