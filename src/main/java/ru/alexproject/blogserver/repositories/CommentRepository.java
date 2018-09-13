package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.dto.CommentDto;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select comment from Comment comment where comment.post = ?1")
    List<CommentDto> getCommentsByPostId(Long postId);
}
