package com.alex.perspektywy.users.domain.enums;

public enum UserStatus {

    IS_MENTOR,
    IS_MENTEE,
    IS_OPEN_FOR_EVENTS,
    IS_OPEN_FOR_PROJECTS,
    IS_VISIBLE_ON_MAP;

    public static UserStatus fromString(String userStatusName) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.name().equalsIgnoreCase(userStatusName)) {
                return userStatus;
            }
        }
        throw new IllegalArgumentException("No enum constant " + userStatusName + " found in UserStatus");
    }
}
