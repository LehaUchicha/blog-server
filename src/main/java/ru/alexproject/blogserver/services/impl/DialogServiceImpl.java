package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexproject.blogserver.model.domain.Dialog;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.domain.UserDialog;
import ru.alexproject.blogserver.repositories.DialogRepository;
import ru.alexproject.blogserver.services.DialogService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogRepository repository;

    public List<UserDialog> getAllDialogs() {
        return repository.findAll();
    }

    public Set<UserDialog> getDialogById(Long id) {
        return repository.findAll().stream()
                .filter(dialog -> dialog.getDialog().getId().equals(id))
                .collect(Collectors.toSet());
    }

    public Set<Dialog> getAllDialogsForUser(Long id) {
        return repository.findAll().stream()
                .filter(userDialog -> userDialog.getUser().getId().equals(id))
                .map(UserDialog::getDialog)
                .collect(Collectors.toSet());
    }

    public Set<User> getAllUsersForDialog(Long id) {
        return repository.findAll().stream()
                .filter(userDialog -> userDialog.getDialog().getId().equals(id))
                .map(UserDialog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(UserDialog userDialogDto) {
        repository.save(userDialogDto);
    }
}
