package com.ssi.integration;

import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.micronaut.http.server.exceptions.*;
import io.micronaut.http.server.exceptions.response.*;
import jakarta.inject.*;

@Produces
@Singleton
public class IntegrationDuplicateExceptionHandler implements ExceptionHandler<IntegrationDuplicateException, HttpResponse<?>> {

    private final ErrorResponseProcessor<?> errorResponseProcessor;

    public IntegrationDuplicateExceptionHandler(ErrorResponseProcessor<?> errorResponseProcessor) {
        this.errorResponseProcessor = errorResponseProcessor;
    }

    @Override
    public HttpResponse<?> handle(HttpRequest request, IntegrationDuplicateException exception) {
        ErrorContext errorContext = ErrorContext.builder(request)
                .cause(exception)
                .errorMessage(exception.getMessage())
                .build();
        return errorResponseProcessor.processResponse(errorContext, HttpResponse.unprocessableEntity());
    }
}