package com.ssi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ssi.integration.Integration;
import com.ssi.integration.IntegrationCommand;
import com.ssi.integration.IntegrationRepository;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Version("1")
@Validated
@Controller("/ssi")
class IntegrationController {
    private final IntegrationRepository integrationRepository;

    IntegrationController(IntegrationRepository integrationRepository) {
        this.integrationRepository = integrationRepository;
    }

    @Get
    public Flux<Integration> list() {
        return integrationRepository.findAll();
    }

    @Post("/effing")
    public MutableHttpResponse<ObjectNode> test(@Body String input) {
        Map x = Map.of( "name", input);
        ObjectNode agencyNode = new ObjectMapper().valueToTree(x);

        return HttpResponse.created(agencyNode);
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Integration save(@Body @Valid IntegrationCommand integrationCommand) {
        return Objects.requireNonNull(integrationRepository
                .saveWithException(integrationCommand)
                .block());
    }

    @Get("/{companyCode}")
    public Mono<Integration> show(@PathVariable String companyCode) {
        return integrationRepository.findByCompanyCode(companyCode);
    }

    @Delete("/{companyCode}")
    @Status(HttpStatus.NO_CONTENT)
    public Mono<HttpResponse<?>> delete(@PathVariable String companyCode) {
        return integrationRepository.deleteIntegration(companyCode).map(deleteId -> HttpResponse.noContent());
    }

    protected URI location(UUID id) {
        return URI.create("/ssi/" + id);
    }

    protected URI location(Integration integration) {
        return location(integration.getId());
    }
}
