package com.ssi.integration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssi.Enums.ClientEntityType;
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import javax.persistence.*;
import java.util.Collection;

@Requires(classes = ClientEntityType.class)
@ReflectiveAccess
@Serdeable
@Entity
@GenerateProxy
@Table
public class ClientEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @NonNull
    @Enumerated(EnumType.STRING)
    private ClientEntityType clientEntityType;

//    @JsonIgnore
//    @OneToMany(
//            mappedBy = "clientEntity",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    Set<ClientEntityDetails> clientEntityDetails = new HashSet<>();

    //    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "integration")
//    @MapsId

//    private Integration integration;

    @Creator
    public ClientEntity(ClientEntityType clientEntityType, Collection<ClientEntityDetails> clientEntityDetails) {
        this.clientEntityType = clientEntityType;
//        this.clientEntityDetails = clientEntityDetails
//                .stream()
//                .peek(details -> details.setClientEntity(this))
//                .collect(Collectors.toSet());
    }

    public ClientEntity() {

    }

//    @JsonAnyGetter
//    public Map<String, Object> any() {
//        return Map.of(this.clientEntityType.toString(), this.clientEntityDetails);
//    }

//    public void addClientEntityDetails(ClientEntityDetails details) {
//        if (this.clientEntityDetails != null) {
//            this.clientEntityDetails.add(details);
//            details.setClientEntity(this);
//        }
//    }
//
//    public void removeClientEntityDetails(ClientEntityDetails details) {
//        if (details != null) {
//            this.clientEntityDetails.remove(details);
//            details.setClientEntity(null);
//        }
//    }
//
//    public void updateClientEntityDetails(Collection<ClientEntityDetails> details) {
//        this.clientEntityDetails.forEach(x -> {
//            if (!details.contains(x)) this.removeClientEntityDetails(x);
//        });
//        details.forEach(this::addClientEntityDetails);
//    }


    public Long getId() {
        return id;
    }

    public ClientEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public ClientEntity setVersion(Long version) {
        this.version = version;
        return this;
    }

    @Column(name = "client_entity_type", columnDefinition = "varchar(20)")
    public ClientEntityType getClientEntityType() {
        return clientEntityType;
    }

    public ClientEntity setClientEntityType(ClientEntityType clientEntityType) {
        this.clientEntityType = clientEntityType;
        return this;
    }
//    @OneToMany(
//            mappedBy = "clientEntity",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER
//    )
//    public Set<ClientEntityDetails> getClientEntityDetails() {
//        return clientEntityDetails;
//    }

//    public ClientEntity setClientEntityDetails(Set<ClientEntityDetails> clientEntityDetails) {
//        this.clientEntityDetails = clientEntityDetails;
//        return this;
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "integration_id")
//    @TypeDef(type = DataType.UUID)
//    public Integration getIntegration() {
//        return integration;
//    }

//    public ClientEntity setIntegration(Integration integration) {
//        this.integration = integration;
//        return this;
//    }

}