package com.ssi.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Serdeable
@Entity
@Table(name = "result_ftp")
public class ResultFTP {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "ftpresultgen")
    @GenericGenerator(name = "ftpresultgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "clientResult"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @Nullable
    private String ftpUsername;
    @Nullable
    private String ftpPassword;
    @Nullable
    private String ftpServer;
    @Nullable
    private String ftpRemoteBaseDir;
    @NotNull
    private Integer ftpPort;
    @Nullable
    private String ftpPrivateKeyLocation;
    @Nullable
    private String payloadFormat;

    @JsonIgnore
    @OneToOne(mappedBy = "ftp", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    ClientResult clientResult;

    @Creator
    public ResultFTP(@Nullable String ftpUsername, @Nullable String ftpPassword, @Nullable String ftpServer, @Nullable String ftpRemoteBaseDir, Integer ftpPort, @Nullable String ftpPrivateKeyLocation, @Nullable String payloadFormat) {
        this.ftpUsername = ftpUsername;
        this.ftpPassword = ftpPassword;
        this.ftpServer = ftpServer;
        this.ftpRemoteBaseDir = ftpRemoteBaseDir;
        this.ftpPort = ftpPort;
        this.ftpPrivateKeyLocation = ftpPrivateKeyLocation;
        this.payloadFormat = payloadFormat;
    }

    public ResultFTP() {

    }

    public UUID getId() {
        return id;
    }

    public ResultFTP setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ResultFTP setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Nullable
    public String getFtpUsername() {
        return ftpUsername;
    }

    public ResultFTP setFtpUsername(@Nullable String ftpUsername) {
        this.ftpUsername = ftpUsername;
        return this;
    }

    @Nullable
    public String getFtpPassword() {
        return ftpPassword;
    }

    public ResultFTP setFtpPassword(@Nullable String ftpPassword) {
        this.ftpPassword = ftpPassword;
        return this;
    }

    @Nullable
    public String getFtpServer() {
        return ftpServer;
    }

    public ResultFTP setFtpServer(@Nullable String ftpServer) {
        this.ftpServer = ftpServer;
        return this;
    }

    @Nullable
    public String getFtpRemoteBaseDir() {
        return ftpRemoteBaseDir;
    }

    public ResultFTP setFtpRemoteBaseDir(@Nullable String ftpRemoteBaseDir) {
        this.ftpRemoteBaseDir = ftpRemoteBaseDir;
        return this;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public ResultFTP setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
        return this;
    }

    @Nullable
    public String getFtpPrivateKeyLocation() {
        return ftpPrivateKeyLocation;
    }

    public ResultFTP setFtpPrivateKeyLocation(@Nullable String ftpPrivateKeyLocation) {
        this.ftpPrivateKeyLocation = ftpPrivateKeyLocation;
        return this;
    }

    @Nullable
    public String getPayloadFormat() {
        return payloadFormat;
    }

    public ResultFTP setPayloadFormat(@Nullable String payloadFormat) {
        this.payloadFormat = payloadFormat;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "ftp", optional = true, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    public ClientResult getClientResult() {
        return clientResult;
    }

    public ResultFTP setClientResult(ClientResult clientResult) {
        this.clientResult = clientResult;
        return this;
    }
}