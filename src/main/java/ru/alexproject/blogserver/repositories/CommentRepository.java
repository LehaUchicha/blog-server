package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexproject.blogserver.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
