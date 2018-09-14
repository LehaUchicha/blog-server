package ru.alexproject.blogserver.model;

import java.util.UUID;

public class EntityUtils {

    private EntityUtils() {
    }

    public static Long newId() {
        return UUID.randomUUID().getMostSignificantBits();
    }
}
