package ru.alexproject.blogserver.utils;

import java.util.UUID;

public class EntityUtils {

    private EntityUtils() {
        //private constructor
    }

    public static Long newId() {
        return UUID.randomUUID().getMostSignificantBits();
    }
}
