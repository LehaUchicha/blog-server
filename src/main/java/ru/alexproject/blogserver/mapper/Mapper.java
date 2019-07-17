package ru.alexproject.blogserver.mapper;

public interface Mapper {

    <FROM, TO> TO convert(FROM from, Class<TO> clazz);
}
