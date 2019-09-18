package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.services.DialogService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.*;

@RestController
@RequestMapping(API_DIALOGS)
@CrossOrigin
public class DialogController {

    private DialogService dialogService;

    private Mapper modelMapper;

    @Autowired
    public DialogController(DialogService dialogService, Mapper modelMapper) {
        this.dialogService = dialogService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<UserDialogDto> getAllDialogs() {
        return dialogService.getAllDialogs().stream()
                .map(userDialog -> modelMapper.convert(userDialog, UserDialogDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = DIALOG_ID)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Set<UserDialogDto> getDialogById(@PathVariable("id") Long id) {
        return dialogService.getDialogById(id).stream()
                .map(userDialog -> modelMapper.convert(userDialog, UserDialogDto.class))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = USER_DIALOGS)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Set<DialogDto> getAllDialogsForUser(@PathVariable("id") Long id) {
        return dialogService.getAllDialogsForUser(id).stream()
                .map(dialog -> modelMapper.convert(dialog, DialogDto.class))
                .collect(Collectors.toSet());
    }

    @GetMapping(value = USERS_FOR_DIALOG)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Set<UserDto> getAllUsersForDialog(@PathVariable("id") Long id) {
        return dialogService.getAllUsersForDialog(id).stream()
                .map(user -> modelMapper.convert(user, UserDto.class))
                .collect(Collectors.toSet());
    }
}
