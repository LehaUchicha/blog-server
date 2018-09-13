package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Post;
import ru.alexproject.blogserver.model.domain.User;

import java.io.Serializable;

public class CommentDto implements Serializable{

    private Long id;

    private String text;

    private User author;

    private Post post;

    private CommentDto(Long id, String text, User author, Post post) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.post = post;
    }

    public static class CommentDtoBuilder {

        private Long id;

        private String text;

        private User author;

        private Post post;

        public CommentDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CommentDtoBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public CommentDtoBuilder withAuthor(User author) {
            this.author = author;
            return this;
        }

        public CommentDtoBuilder withPost(Post post) {
            this.post = post;
            return this;
        }

        public CommentDto please() {
            return new CommentDto(id, text, author, post);
        }
    }

    public static CommentDtoBuilder build() {
        return new CommentDtoBuilder();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public Comment toEntity() {
        return new Comment()
                .setId(id)
                .setAuthor(author)
                .setPost(post)
                .setText(text);
    }
}
