package ru.alexproject.blogserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Like;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;

import java.util.Set;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query(value = "select like from Like like where like.comment is not null", nativeQuery = true)
    Set<Like> getLikesOnComment();

    @Query(value = "select like from Like like where like.post is not null", nativeQuery = true)
    Set<Like> getLikesOnPosts();

    @Query(value = "select l from Like l where l.comment.id = :commentId")
    Set<Like> getLikesByCommentId(@Param("commentId") Long id);

    @Query(value = "SELECT l FROM Like l WHERE l.post.id = :postId")
    Set<Like> getLikesByPostId(@Param("postId") Long id);

    @Query(value = "select l from Like l where l.post = :post and l.user = :user")
    Like findLikesByUserAndPost(@Param("post") Post post,
                                @Param("user") User user);

    @Query(value = "select l from Like l where l.comment = :comment and l.user = :user")
    Like findLikesByUserAndComment(@Param("comment") Comment comment,
                                   @Param("user") User user);
}
