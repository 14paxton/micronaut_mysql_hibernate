package com.ssi.integration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import javax.persistence.*;

@ReflectiveAccess
@Serdeable
@Entity
@Table
public class ClientEntityDetails {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonIgnore
    @Version
    private Long version;

    @Nullable
    private String externalCode;
    @Nullable
    private String description;
    @Nullable
    private String value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientEntity")
    private ClientEntity clientEntity;

    @Creator
    public ClientEntityDetails(@Nullable String externalCode, @Nullable String description, @Nullable String value) {
        this.externalCode = externalCode;
        this.description = description;
        this.value = value;
    }

    public ClientEntityDetails() {

    }

    public Long getId() {
        return id;
    }

    public ClientEntityDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ClientEntityDetails setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Nullable
    public String getExternalCode() {
        return externalCode;
    }

    public ClientEntityDetails setExternalCode(@Nullable String externalCode) {
        this.externalCode = externalCode;
        return this;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public ClientEntityDetails setDescription(@Nullable String description) {
        this.description = description;
        return this;
    }

    @Nullable
    public String getValue() {
        return value;
    }

    public ClientEntityDetails setValue(@Nullable String value) {
        this.value = value;
        return this;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientEntity")
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public ClientEntityDetails setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}