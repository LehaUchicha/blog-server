package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.UserDto;

public class UserServiceTest extends BaseTest {

    @Test
    public void testCreateUser() {
        UserDto userDto = createBaseUserDto();
        userService.save(modelMapper.convert(userDto, User.class));
        Assert.assertNotNull(userService.findUserById(userDto.getId()));
    }
}
