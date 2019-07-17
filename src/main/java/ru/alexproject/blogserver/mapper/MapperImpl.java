package ru.alexproject.blogserver.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <FROM, TO> TO convert(FROM from, Class<TO> clazz) {
        return modelMapper.map(from, clazz);
    }
}
