package com.ssi.request;

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
@Table(name = "request_ftp")
public class RequestFTP {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "ftpgen")
    @GenericGenerator(name = "ftpgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "wSConfig"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @Nullable
    private Long ftpArchiveLimitSecs;
    @Nullable
    private String ftpPassword;
    @Nullable
    private String ftpPrivateKeyLocation;
    @Nullable
    private String ftpRemoteBaseDir;
    @Nullable
    private String ftpUsername;
    @Nullable
    private String fetchFileStringPattern;
    @NotNull
    private Integer ftpPort;
    @NotNull
    private String ftpServer;

    @JsonIgnore
    @OneToOne(mappedBy = "ftp", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    WSConfig wSConfig;

    @Creator
    public RequestFTP(@Nullable Long ftpArchiveLimitSecs, @Nullable String ftpPassword, @Nullable String ftpPrivateKeyLocation, @Nullable String ftpRemoteBaseDir, @Nullable String ftpUsername, @Nullable String fetchFileStringPattern, Integer ftpPort, String ftpServer) {
        this.ftpArchiveLimitSecs = ftpArchiveLimitSecs;
        this.ftpPassword = ftpPassword;
        this.ftpPrivateKeyLocation = ftpPrivateKeyLocation;
        this.ftpRemoteBaseDir = ftpRemoteBaseDir;
        this.ftpUsername = ftpUsername;
        this.fetchFileStringPattern = fetchFileStringPattern;
        this.ftpPort = ftpPort;
        this.ftpServer = ftpServer;
    }

    public RequestFTP() {

    }

    public UUID getId() {
        return id;
    }

    public RequestFTP setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public RequestFTP setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Nullable
    public Long getFtpArchiveLimitSecs() {
        return ftpArchiveLimitSecs;
    }

    public RequestFTP setFtpArchiveLimitSecs(@Nullable Long ftpArchiveLimitSecs) {
        this.ftpArchiveLimitSecs = ftpArchiveLimitSecs;
        return this;
    }

    @Nullable
    public String getFtpPassword() {
        return ftpPassword;
    }

    public RequestFTP setFtpPassword(@Nullable String ftpPassword) {
        this.ftpPassword = ftpPassword;
        return this;
    }

    @Nullable
    public String getFtpPrivateKeyLocation() {
        return ftpPrivateKeyLocation;
    }

    public RequestFTP setFtpPrivateKeyLocation(@Nullable String ftpPrivateKeyLocation) {
        this.ftpPrivateKeyLocation = ftpPrivateKeyLocation;
        return this;
    }

    @Nullable
    public String getFtpRemoteBaseDir() {
        return ftpRemoteBaseDir;
    }

    public RequestFTP setFtpRemoteBaseDir(@Nullable String ftpRemoteBaseDir) {
        this.ftpRemoteBaseDir = ftpRemoteBaseDir;
        return this;
    }

    @Nullable
    public String getFtpUsername() {
        return ftpUsername;
    }

    public RequestFTP setFtpUsername(@Nullable String ftpUsername) {
        this.ftpUsername = ftpUsername;
        return this;
    }

    @Nullable
    public String getFetchFileStringPattern() {
        return fetchFileStringPattern;
    }

    public RequestFTP setFetchFileStringPattern(@Nullable String fetchFileStringPattern) {
        this.fetchFileStringPattern = fetchFileStringPattern;
        return this;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public RequestFTP setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
        return this;
    }

    public String getFtpServer() {
        return ftpServer;
    }

    public RequestFTP setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer;
        return this;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "ftp", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapsId("id")
    public WSConfig getWSConfig() {
        return wSConfig;
    }

    public RequestFTP setWSConfig(WSConfig wSConfig) {
        this.wSConfig = wSConfig;
        return this;
    }
}