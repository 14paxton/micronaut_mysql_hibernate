package com.ssi.integration;

import com.ssi.Enums.ClientEntityType;
import com.ssi.request.WSConfigCommand;
import com.ssi.result.ClientResultCommand;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@Serdeable
public class IntegrationCommand {
    @Nullable
    private final String id;

    @Nullable
    private final String companyCode;

    @Nullable
    private final String externalClientId;

    @Nullable
    private final Long organization;

    @Nullable
    private final String tbeCompanyCode;

    @Nullable
    private final String tbexPassword;

    @Valid
    @Nullable
    private final WSConfigCommand wSConfig;

    @Valid
    @Nullable
    private final ClientResultCommand clientResult;

    @Nullable
    private final Map<ClientEntityType, List<ClientEntityDetails>> clientEntityMap;

    public IntegrationCommand(@Nullable String id, @Nullable String companyCode, @Nullable String externalClientId, @Nullable Long organization, @Nullable String tbeCompanyCode, @Nullable String tbexPassword, @Nullable WSConfigCommand wSConfig, @Nullable ClientResultCommand clientResult, @Nullable Map<ClientEntityType, List<ClientEntityDetails>> clientEntityMap) {
        this.id = id;
        this.companyCode = companyCode;
        this.externalClientId = externalClientId;
        this.organization = organization;
        this.tbeCompanyCode = tbeCompanyCode;
        this.tbexPassword = tbexPassword;
        this.wSConfig = wSConfig;
        this.clientResult = clientResult;
        this.clientEntityMap = clientEntityMap;
    }

    @Creator
    public IntegrationCommand(String companyCode, @Nullable String externalClientId, @Nullable Long organization, @Nullable String tbeCompanyCode, @Nullable String tbexPassword, @Nullable WSConfigCommand wSConfig, @Nullable ClientResultCommand clientResultConfig, @Nullable Map<ClientEntityType, List<ClientEntityDetails>> clientEntityMap) {
        this(null, companyCode,  externalClientId,  organization,  tbeCompanyCode,  tbexPassword, wSConfig, clientResultConfig, clientEntityMap);
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public String getCompanyCode() {
        return companyCode;
    }

    @Nullable
    public String getExternalClientId() {
        return externalClientId;
    }

    @Nullable
    public Long getOrganization() {
        return organization;
    }

    @Nullable
    public String getTbeCompanyCode() {
        return tbeCompanyCode;
    }

    @Nullable
    public String getTbexPassword() {
        return tbexPassword;
    }


    @Nullable
    public WSConfigCommand getwSConfig() {
        return wSConfig;
    }


    @Nullable
    public ClientResultCommand getClientResult() {
        return clientResult;
    }

    @Nullable
    public Map<ClientEntityType, List<ClientEntityDetails>> getClientEntityMap() {
        return clientEntityMap;
    }
}
