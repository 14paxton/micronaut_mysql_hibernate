package com.ssi.integration;

public class IntegrationDuplicateException extends RuntimeException {
    public IntegrationDuplicateException(String companyCode) {
        super("Company " + companyCode + " exists");
    }
}