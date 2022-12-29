package com.ssi.integration;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssi.request.WSConfig;
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@ReflectiveAccess
@Serdeable
@Entity
@GenerateProxy
public class Integration {
    @JsonIgnore
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;
    @JsonIgnore
    @DateCreated
    Date dateCreated;

    @JsonIgnore
    @DateUpdated
    Date dateUpdated;
    @NonNull
    @NaturalId
    private String companyCode;
    @Nullable
    private String externalClientId;
    @Nullable
    private Long organization;
    @Nullable
    private String tbeCompanyCode;

    //TODO remove password being passed in, have it randomly generated
    @Nullable
    private String tbexPassword;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn( name="w_s_config", nullable=false, updatable=false)
    private WSConfig wSConfig;

//    private ClientResult clientResult;

//    private Set<ClientEntity> clientEntityMap = new HashSet<>();

    @Creator
    public Integration(@NonNull String companyCode,
                       @Nullable String externalClientId,
                       @Nullable Long organization,
                       @Nullable String tbeCompanyCode,
                       @Nullable String tbexPassword) {
        this.companyCode = companyCode;
        this.externalClientId = externalClientId;
        this.organization = organization;
        this.tbeCompanyCode = tbeCompanyCode;
        this.tbexPassword = tbexPassword;
    }

    public Integration() {

    }

//    public void addClientEntityMap(ClientEntity clientEntity) {
//        if (this.clientEntityMap != null) {
//            this.clientEntityMap.add(clientEntity);
//            clientEntity.setIntegration(this);
//        }
//    }
//
//    public void removeClientEntityMap(ClientEntity clientEntity) {
//        if (clientEntity != null) {
//            this.clientEntityMap.remove(clientEntity);
//            clientEntity.setIntegration(null);
//        }
//    }
//
//    public void updateClientEntityMap(Collection<ClientEntity> clienEntities) {
//        this.clientEntityMap.forEach(x -> {
//            if (!clienEntities.contains(x)) this.removeClientEntityMap(x);
//        });
//        clienEntities.forEach(this::addClientEntityMap);
//    }

//    @JsonGetter("clientEntityMap")
//    public Map<String, Set<ClientEntityDetails>> getClientEntities() {
//        if (clientEntityMap != null && clientEntityMap.size() > 0) {
//            return this.clientEntityMap
//                    .stream()
//                    .collect(Collectors.toMap(ent -> ent.getClientEntityType().toString(), ClientEntity::getClientEntityDetails));
//        }
//
//        return null;
//    }


    public UUID getId() {
        return id;
    }

    public Integration setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public Integration setVersion(Long version) {
        this.version = version;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Integration setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public Integration setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    @NonNull
    public String getCompanyCode() {
        return companyCode;
    }

    public Integration setCompanyCode(@NonNull String companyCode) {
        this.companyCode = companyCode;
        return this;
    }

    @Nullable
    public String getExternalClientId() {
        return externalClientId;
    }

    public Integration setExternalClientId(@Nullable String externalClientId) {
        this.externalClientId = externalClientId;
        return this;
    }

    @Nullable
    public Long getOrganization() {
        return organization;
    }

    public Integration setOrganization(@Nullable Long organization) {
        this.organization = organization;
        return this;
    }

    @Nullable
    public String getTbeCompanyCode() {
        return tbeCompanyCode;
    }

    public Integration setTbeCompanyCode(@Nullable String tbeCompanyCode) {
        this.tbeCompanyCode = tbeCompanyCode;
        return this;
    }

    @Nullable
    public String getTbexPassword() {
        return tbexPassword;
    }

    public Integration setTbexPassword(@Nullable String tbexPassword) {
        this.tbexPassword = tbexPassword;
        return this;
    }

    public WSConfig getWSConfig() {
        return wSConfig;
    }

    public Integration setWSConfig(WSConfig wSConfig) {
        this.wSConfig = wSConfig;
        return this;
    }
}