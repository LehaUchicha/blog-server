package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Dialog;
import ru.alexproject.blogserver.model.Message;
import ru.alexproject.blogserver.model.User;
import ru.alexproject.blogserver.model.UserDialog;
import ru.alexproject.blogserver.repositories.DialogRepository;
import ru.alexproject.blogserver.repositories.MessageRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.*;

@RestController
@RequestMapping(API_DIALOGS)
@CrossOrigin
public class DialogController {

    @Autowired
    private DialogRepository dialogRepository;

    @GetMapping
    private List<UserDialog> getAllDialogs() {
        return dialogRepository.findAll();
    }

    @GetMapping(value = DIALOG_ID)
    private Set<UserDialog> getDialogById(@PathVariable("id") Long id) {
        return dialogRepository.findAll().stream()
                .filter(dialog -> dialog.getDialog().getId().equals(id))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = USER_DIALOGS)
    private Set<Dialog> getAllDialogsForUser(@PathVariable("id") Long id) {
        return dialogRepository.findAll().stream()
                .filter(userDialog -> userDialog.getUser().getId().equals(id))
                .map(userDialog -> userDialog.getDialog())
                .distinct()
                .collect(Collectors.toSet());
    }

    @GetMapping(value = USERS_FOR_DIALOG)
    private Set<User> getAllUsersForDialog(@PathVariable("id") Long id) {
        return dialogRepository.findAll().stream()
                .filter(userDialog -> userDialog.getDialog().getId().equals(id))
                .map(userDialog -> userDialog.getUser())
                .distinct()
                .collect(Collectors.toSet());
    }
}
