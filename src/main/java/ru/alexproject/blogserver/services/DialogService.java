package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.domain.Dialog;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.domain.UserDialog;
import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface DialogService {

    List<UserDialog> getAllDialogs();

    Set<UserDialog> getDialogById(Long id);

    Set<Dialog> getAllDialogsForUser(Long id);

    Set<User> getAllUsersForDialog(Long id);

    void save(UserDialog userDialogDto);
}
