package ru.alexproject.blogserver.model;

import java.util.UUID;

public class EntityUtils {

    public static Long newId() {
        return UUID.randomUUID().getMostSignificantBits();
    }
}
