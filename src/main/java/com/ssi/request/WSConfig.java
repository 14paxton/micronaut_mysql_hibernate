package com.ssi.request;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.ssi.Enums.CountryCodeFormat;
import com.ssi.integration.Integration;
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.*;

@Requires(classes = CountryCodeFormat.class)
@ReflectiveAccess
@Serdeable
@Entity
@TypeHint(
        value = {
                HashMap.class,
                Map.class
        },
        accessType = TypeHint.AccessType.ALL_DECLARED_CONSTRUCTORS
)
@Table(name = "w_s_config")
public class WSConfig {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "wsconfiggen")
    @GenericGenerator(name = "wsconfiggen", strategy = "foreign", parameters = @Parameter(name = "property", value = "integration"))
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonIgnore
    @Version
    private Long version;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private RequestREST rest;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private RequestSOAP soap;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private RequestFTP ftp;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @Nullable
    @TypeDef(type = DataType.JSON)
    @Column(name = "custom_aor_map", columnDefinition = "tinyblob")
    @CollectionTable
    @ElementCollection(targetClass = HashMap.class , fetch = FetchType.EAGER)
    private Map<String, String> customAORMap;
    @Nullable
    @Enumerated(EnumType.STRING)
    private CountryCodeFormat countryCodeFormat;
    @Nullable
    private Boolean allowNoAuth = false;

    @Nullable
    private Boolean active = true;

    @Nullable
    private Boolean transformRequestIn;

    @Nullable
    private Boolean transformRequestResponse;

    @Nullable
    private Boolean transformStatusIn;

    @Nullable
    private Boolean transformStatusResponse;

    @Nullable
    private String assessmentOrderRequestXSLIn;

    @Nullable
    private String assessmentOrderRequestXSLOut;

    @Nullable
    private String assessmentStatusRequestXSLIn;

    @Nullable
    private String assessmentStatusRequestXSLOut;

    @Nullable
    private String description;

    @JsonIgnore
    @OneToOne(optional = false, mappedBy = "wSConfig")
    @MapsId("id")
    private Integration integration;

    @Creator
    public WSConfig(@Nullable RequestREST rest,
                    @Nullable RequestSOAP soap,
                    @Nullable RequestFTP ftp,
                    @Nullable HashMap<String, String> customAORMap,
                    @Nullable CountryCodeFormat countryCodeFormat,
                    @Nullable Boolean allowNoAuth,
                    @Nullable Boolean active,
                    @Nullable Boolean transformRequestIn,
                    @Nullable Boolean transformRequestResponse,
                    @Nullable Boolean transformStatusIn,
                    @Nullable Boolean transformStatusResponse,
                    @Nullable String assessmentOrderRequestXSLIn,
                    @Nullable String assessmentOrderRequestXSLOut,
                    @Nullable String assessmentStatusRequestXSLIn,
                    @Nullable String assessmentStatusRequestXSLOut,
                    @Nullable String description,
                    @NotNull Integration integration) {
        if (rest != null) {
            rest.setWSConfig(this);
            this.rest = rest;
        }
        if (soap != null) {
            soap.setWSConfig(this);
            this.soap = soap;
        }
        if (ftp != null) {
            ftp.setWSConfig(this);
            this.ftp = ftp;
        }
        Optional<HashMap<String, String>> aorMap = Optional.ofNullable(customAORMap);
        aorMap.ifPresent(map -> this.customAORMap = map);
        this.countryCodeFormat = countryCodeFormat;
        this.allowNoAuth = allowNoAuth;
        this.active = active;
        this.transformRequestIn = transformRequestIn;
        this.transformRequestResponse = transformRequestResponse;
        this.transformStatusIn = transformStatusIn;
        this.transformStatusResponse = transformStatusResponse;
        this.assessmentOrderRequestXSLIn = assessmentOrderRequestXSLIn;
        this.assessmentOrderRequestXSLOut = assessmentOrderRequestXSLOut;
        this.assessmentStatusRequestXSLIn = assessmentStatusRequestXSLIn;
        this.assessmentStatusRequestXSLOut = assessmentStatusRequestXSLOut;
        this.description = description;
        this.integration = integration;
    }

    public WSConfig(WSConfigCommand wSConfigCommand, Integration integration) {
        this(wSConfigCommand.getRest(),
                wSConfigCommand.getSoap(),
                wSConfigCommand.getFtp(),
                wSConfigCommand.getCustomAORMap(),
                wSConfigCommand.getCountryCodeFormat(),
                wSConfigCommand.getAllowNoAuth(),
                wSConfigCommand.getActive(),
                wSConfigCommand.getTransformRequestIn(),
                wSConfigCommand.getTransformRequestResponse(),
                wSConfigCommand.getTransformStatusIn(),
                wSConfigCommand.getTransformStatusResponse(),
                wSConfigCommand.getAssessmentOrderRequestXSLIn(),
                wSConfigCommand.getAssessmentOrderRequestXSLOut(),
                wSConfigCommand.getAssessmentStatusRequestXSLIn(),
                wSConfigCommand.getAssessmentStatusRequestXSLOut(),
                wSConfigCommand.getDescription(),
                integration);
    }

    public WSConfig() {

    }

    public UUID getId() {
        return id;
    }

    public WSConfig setId(UUID id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public WSConfig setVersion(Long version) {
        this.version = version;
        return this;
    }

    public RequestREST getRest() {
        return rest;
    }

    public WSConfig setRest(RequestREST rest) {
        this.rest = rest;
        return this;
    }

    public RequestSOAP getSoap() {
        return soap;
    }

    public WSConfig setSoap(RequestSOAP soap) {
        this.soap = soap;
        return this;
    }

    public RequestFTP getFtp() {
        return ftp;
    }

    public WSConfig setFtp(RequestFTP ftp) {
        this.ftp = ftp;
        return this;
    }


    @Nullable
    public Map<String, String> getCustomAORMap() {
        return customAORMap;
    }

//    @JsonAnySetter
//    public void add(String key, String value) {
//        if (customAORMap != null) {
//            customAORMap.put(key, value);
//        }
//    }

    //    @JsonSetter("customAORMap")
    public WSConfig setCustomAORMap(@Nullable Map<String, String> customAORMap) {
        this.customAORMap = customAORMap;
        return this;
    }

    @Nullable
    public CountryCodeFormat getCountryCodeFormat() {
        return countryCodeFormat;
    }

    public WSConfig setCountryCodeFormat(@Nullable CountryCodeFormat countryCodeFormat) {
        this.countryCodeFormat = countryCodeFormat;
        return this;
    }

    @Nullable
    public Boolean getAllowNoAuth() {
        return allowNoAuth;
    }

    public WSConfig setAllowNoAuth(@Nullable Boolean allowNoAuth) {
        this.allowNoAuth = allowNoAuth;
        return this;
    }

    @Nullable
    public Boolean getActive() {
        return active;
    }

    public WSConfig setActive(@Nullable Boolean active) {
        this.active = active;
        return this;
    }

    @Nullable
    public Boolean getTransformRequestIn() {
        return transformRequestIn;
    }

    public WSConfig setTransformRequestIn(@Nullable Boolean transformRequestIn) {
        this.transformRequestIn = transformRequestIn;
        return this;
    }

    @Nullable
    public Boolean getTransformRequestResponse() {
        return transformRequestResponse;
    }

    public WSConfig setTransformRequestResponse(@Nullable Boolean transformRequestResponse) {
        this.transformRequestResponse = transformRequestResponse;
        return this;
    }

    @Nullable
    public Boolean getTransformStatusIn() {
        return transformStatusIn;
    }

    public WSConfig setTransformStatusIn(@Nullable Boolean transformStatusIn) {
        this.transformStatusIn = transformStatusIn;
        return this;
    }

    @Nullable
    public Boolean getTransformStatusResponse() {
        return transformStatusResponse;
    }

    public WSConfig setTransformStatusResponse(@Nullable Boolean transformStatusResponse) {
        this.transformStatusResponse = transformStatusResponse;
        return this;
    }

    @Nullable
    public String getAssessmentOrderRequestXSLIn() {
        return assessmentOrderRequestXSLIn;
    }

    public WSConfig setAssessmentOrderRequestXSLIn(@Nullable String assessmentOrderRequestXSLIn) {
        this.assessmentOrderRequestXSLIn = assessmentOrderRequestXSLIn;
        return this;
    }

    @Nullable
    public String getAssessmentOrderRequestXSLOut() {
        return assessmentOrderRequestXSLOut;
    }

    public WSConfig setAssessmentOrderRequestXSLOut(@Nullable String assessmentOrderRequestXSLOut) {
        this.assessmentOrderRequestXSLOut = assessmentOrderRequestXSLOut;
        return this;
    }

    @Nullable
    public String getAssessmentStatusRequestXSLIn() {
        return assessmentStatusRequestXSLIn;
    }

    public WSConfig setAssessmentStatusRequestXSLIn(@Nullable String assessmentStatusRequestXSLIn) {
        this.assessmentStatusRequestXSLIn = assessmentStatusRequestXSLIn;
        return this;
    }

    @Nullable
    public String getAssessmentStatusRequestXSLOut() {
        return assessmentStatusRequestXSLOut;
    }

    public WSConfig setAssessmentStatusRequestXSLOut(@Nullable String assessmentStatusRequestXSLOut) {
        this.assessmentStatusRequestXSLOut = assessmentStatusRequestXSLOut;
        return this;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public WSConfig setDescription(@Nullable String description) {
        this.description = description;
        return this;
    }

    public Integration getIntegration() {
        return integration;
    }

    public WSConfig setIntegration(Integration integration) {
        this.integration = integration;
        return this;
    }
}