package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Like;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;

import java.io.Serializable;

public class LikeDto implements Serializable{

    private LikeDto() {
    }

    private Long id;

    private User user;

    private Post post;

    private Comment comment;

    private LikeDto(Long id, User user, Post post, Comment comment) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.comment = comment;
    }

    public static class LikeDtoBuilder {

        private Long id;

        private User user;

        private Post post;

        private Comment comment;

        public LikeDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public LikeDtoBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public LikeDtoBuilder setPost(Post post) {
            this.post = post;
            return this;
        }

        public LikeDtoBuilder setComment(Comment comment) {
            this.comment = comment;
            return this;
        }

        public LikeDto please() {
            return new LikeDto(id, user, post, comment);
        }
    }

    public static LikeDtoBuilder build() {
        return new LikeDtoBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Like toEntity() {
        return new Like()
                .setId(id)
                .setUser(user)
                .setPost(post)
                .setComment(comment);
    }
}
