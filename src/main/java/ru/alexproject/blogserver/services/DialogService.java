package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface DialogService {

    List<UserDialogDto> getAllDialogs();

    Set<UserDialogDto> getDialogById(Long id);

    Set<DialogDto> getAllDialogsForUser(Long id);

    Set<UserDto> getAllUsersForDialog(Long id);
}
