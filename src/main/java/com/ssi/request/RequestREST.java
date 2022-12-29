package com.ssi.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Serdeable
@Entity
@Table(name = "request_rest")
public class RequestREST {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "restrequestgen")
    @GenericGenerator(name = "restrequestgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "wSConfig"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @NotNull
    private String apiPassword;
    @NotNull
    private String apiUsername;
    @NotNull
    private String apiWebAddress;

    @JsonIgnore
    @OneToOne(mappedBy = "rest", optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId("id")
    WSConfig wSConfig;

    public RequestREST(String apiPassword, String apiUsername, String apiWebAddress) {
        this.apiPassword = apiPassword;
        this.apiUsername = apiUsername;
        this.apiWebAddress = apiWebAddress;
    }

    public RequestREST() {

    }

    public UUID getId() {
        return id;
    }

    public RequestREST setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public RequestREST setVersion(Long version) {
        this.version = version;
        return this;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public RequestREST setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
        return this;
    }

    public String getApiUsername() {
        return apiUsername;
    }

    public RequestREST setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
        return this;
    }

    public String getApiWebAddress() {
        return apiWebAddress;
    }

    public RequestREST setApiWebAddress(String apiWebAddress) {
        this.apiWebAddress = apiWebAddress;
        return this;
    }

     @JsonIgnore
    @OneToOne(mappedBy = "rest", optional = true, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId("id")
    public WSConfig getWSConfig() {
        return wSConfig;
    }

    public RequestREST setWSConfig(WSConfig wSConfig) {
        this.wSConfig = wSConfig;
        return this;
    }
}