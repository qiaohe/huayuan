package com.huayuan.mms.domain;

/**
 * Created by Administrator on 14-3-27.
 */
public enum SexEnum {
    MALE("女"),
    FEMALE("男");

    private final String name;

    SexEnum(String name) {
        this.name = name;
    }

    public static SexEnum fromName(final String name) {
        for (SexEnum se : values()) {
            if (name.equalsIgnoreCase(se.name)) {
                return se;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
