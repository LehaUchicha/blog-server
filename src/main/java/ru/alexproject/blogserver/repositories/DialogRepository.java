package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexproject.blogserver.model.Message;
import ru.alexproject.blogserver.model.UserDialog;

public interface DialogRepository extends JpaRepository<UserDialog, Long> {
}
