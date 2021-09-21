package com.bitlo.utils;

import org.springframework.http.HttpHeaders;

public final class HeaderUtil {

    private static final String APPLICATION_NAME = "bitloUserWallet";

    private HeaderUtil() {
    }

    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-bitloUserWallet-alert", message);
        headers.add("X-bitloUserWallet-params", param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return createAlert(APPLICATION_NAME + "." + entityName + ".created", param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert(APPLICATION_NAME + "." + entityName + ".updated", param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert(APPLICATION_NAME + "." + entityName + ".deleted", param);
    }

    public static HttpHeaders createEntityDeletionFailedAlert(String entityName, String param) {
        return createFailureAlert(entityName, entityName + ".delete.failed", entityName + " Can not delete");
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        return createFailureAlert(entityName, "error.", errorKey, defaultMessage);
    }

    public static HttpHeaders createFailureAlert(String entityName, String prefix, String errorKey, String defaultMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-bitloUserWallet-error", prefix + errorKey);
        headers.add("X-bitloUserWallet-params", entityName);
        return headers;
    }

}
