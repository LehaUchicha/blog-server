package ru.alexproject.blogserver.services;

import org.junit.Assert;
import org.junit.Test;
import ru.alexproject.blogserver.BaseTest;
import ru.alexproject.blogserver.model.domain.UserDialog;
import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;

public class DialogServiceTest extends BaseTest {

    @Test
    public void testCreateDialog() {
        DialogDto dialogDto = createBaseDialog();
        UserDto userDto = createBaseUserDto();
        UserDialogDto userDialogDto = createBaseUserDialogDto();
        userDialogDto.setDialog(dialogDto);
        userDialogDto.setUser(userDto);
        dialogService.save(modelMapper.convert(userDialogDto, UserDialog.class));
        Assert.assertNotNull(dialogService.getDialogById(dialogDto.getId()));
    }
}
