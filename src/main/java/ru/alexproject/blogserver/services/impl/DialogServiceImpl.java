package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.UserDialog;
import ru.alexproject.blogserver.model.dto.DialogDto;
import ru.alexproject.blogserver.model.dto.UserDialogDto;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.repositories.DialogRepository;
import ru.alexproject.blogserver.services.DialogService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogRepository repository;

    public List<UserDialogDto> getAllDialogs() {
        return repository.findAll().stream()
                .map(UserDialog::toDto)
                .collect(Collectors.toList());
    }

    public Set<UserDialogDto> getDialogById(Long id) {
        return repository.findAll().stream()
                .filter(dialog -> dialog.getDialog().getId().equals(id))
                .map(UserDialog::toDto)
                .collect(Collectors.toSet());
    }

    public Set<DialogDto> getAllDialogsForUser(Long id) {
        return repository.findAll().stream()
                .filter(userDialog -> userDialog.getUser().getId().equals(id))
                .map(userDialog -> userDialog.getDialog().toDto())
                .distinct()
                .collect(Collectors.toSet());
    }

    public Set<UserDto> getAllUsersForDialog(Long id) {
        return repository.findAll().stream()
                .filter(userDialog -> userDialog.getDialog().getId().equals(id))
                .map(userDialog -> userDialog.getUser().toDto())
                .distinct()
                .collect(Collectors.toSet());
    }
}
