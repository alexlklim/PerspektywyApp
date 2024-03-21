package com.alex.perspektywy.notification.domain;

public enum Reason {
    ACCOUNT_CREATED, PASSWORD_WAS_CHANGED,
    USER_WAS_ENABLED, YOU_WERE_ENABLED,
    USER_WAS_DISABLED, YOU_WERE_DISABLED;


    public static Reason fromString(String value) {
        for (Reason reason : Reason.values()) {
            if (reason.name().equalsIgnoreCase(value)) {
                return reason;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in enum Reason");
    }

}
