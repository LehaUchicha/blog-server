package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexproject.blogserver.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
