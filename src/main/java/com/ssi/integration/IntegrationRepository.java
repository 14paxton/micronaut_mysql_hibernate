package com.ssi.integration;

import com.ssi.request.WSConfig;
import com.ssi.result.ClientResult;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.annotation.EntityGraph;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface IntegrationRepository extends ReactorPageableRepository<Integration, UUID> {
    @Transactional
    default Mono<Integration> saveWithException(@NonNull IntegrationCommand integrationCommand) {
        Integration newIntegration = new Integration(integrationCommand.getCompanyCode(), integrationCommand.getExternalClientId(), integrationCommand.getOrganization(), integrationCommand.getTbeCompanyCode(), integrationCommand.getTbexPassword());
        ClientResult clientResult = new ClientResult(integrationCommand.getClientResult(), newIntegration);
        WSConfig wSConfig = new WSConfig(integrationCommand.getwSConfig(), newIntegration);
        if (integrationCommand.getClientEntityMap() != null) {
            integrationCommand.getClientEntityMap().forEach((key, value) -> {
                ClientEntity newClientEntity = new ClientEntity(key, value);
//                newIntegration.addClientEntityMap(newClientEntity);
            });
        }
//        newIntegration.setClientResult(clientResult);
        newIntegration.setWSConfig(wSConfig);

        return save(newIntegration);
    }

    //    Mono<Integration> update(@NonNull  @Valid IntegrationCommand integrationCommand);
    Mono<UUID> findIdByCompanyCode(@NonNull String companyCode);

//        @EntityGraph(attributePaths = { "wSConfig", "wSConfig.integration", "wSConfig.rest"})
//    @Join(value = "clientEntityMap", type = Join.Type.LEFT_FETCH)
    @NonNull
//     @EntityGraph(attributePaths = { "wSConfig", "wSConfig.customAORMap", "wSConfig.integration", "wSConfig.rest", "wSConfig.soap", "wSConfig.ftp"})
    Mono<Integration> findById(@NonNull UUID id);

    @NonNull
    Flux<Integration> findAll();

    default Mono<Integration> findByCompanyCode(@NonNull String companyCode) {
        UUID id = findIdByCompanyCode(companyCode).block();
        return findById(id);
    }

    default Mono<Long> deleteIntegration(@NonNull String companyCode) {
        UUID id = findIdByCompanyCode(companyCode).block();
        if (id != null) {
            return deleteById(id);
        }

        return null;
    }
}