package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.services.DialogService;

import java.util.List;
import java.util.Set;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.*;

@RestController
@RequestMapping(API_DIALOGS)
@CrossOrigin
public class DialogController {

    @Autowired
    private DialogService dialogService;

    @GetMapping
    private List<UserDialogDto> getAllDialogs() {
        return dialogService.getAllDialogs();
    }

    @GetMapping(value = DIALOG_ID)
    private Set<UserDialogDto> getDialogById(@PathVariable("id") Long id) {
        return dialogService.getDialogById(id);
    }

    @GetMapping(value = USER_DIALOGS)
    private Set<DialogDto> getAllDialogsForUser(@PathVariable("id") Long id) {
        return dialogService.getAllDialogsForUser(id);
    }

    @GetMapping(value = USERS_FOR_DIALOG)
    private Set<UserDto> getAllUsersForDialog(@PathVariable("id") Long id) {
        return dialogService.getAllUsersForDialog(id);
    }
}
