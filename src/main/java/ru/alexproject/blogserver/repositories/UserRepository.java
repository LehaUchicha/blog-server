package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexproject.blogserver.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String uername);
}
