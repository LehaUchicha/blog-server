package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Post;

import java.io.Serializable;
import java.util.List;

public class PostDto implements Serializable {

    private PostDto() {
    }

    private Long id;

    private String title;

    private String shortText;

    private String fullText;

    private List<Comment> comments;

    private PostDto(Long id, String title, String shortText, String fullText, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.comments = comments;
    }

    public static class PostDtoBuilder {

        private Long id;

        private String title;

        private String shortText;

        private String fullText;

        private List<Comment> comments;

        public PostDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PostDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostDtoBuilder withShortText(String shortText) {
            this.shortText = shortText;
            return this;
        }

        public PostDtoBuilder withFullText(String fullText) {
            this.fullText = fullText;
            return this;
        }

        public PostDtoBuilder withComments(List<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public PostDto please() {
            return new PostDto(id, title, shortText, fullText, comments);
        }
    }

    public static PostDtoBuilder build() {
        return new PostDtoBuilder();
    }

    public Post toEntity() {
        return new Post()
                .setId(id)
                .setTitle(title)
                .setShortText(shortText)
                .setFullText(fullText)
                .setComments(comments);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof PostDto)) return false;

        PostDto postDto = (PostDto) obj;

        return id.equals(postDto.id) &&
                title.equals(postDto.title) &&
                shortText.equals(postDto.shortText) &&
                comments.equals(postDto.comments);
    }
}
