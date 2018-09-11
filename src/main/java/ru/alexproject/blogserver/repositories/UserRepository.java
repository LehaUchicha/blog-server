package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alexproject.blogserver.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String uername);
}
