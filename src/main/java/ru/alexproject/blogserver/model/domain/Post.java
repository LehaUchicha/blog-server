package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.alexproject.blogserver.model.dto.PostDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex on 21.03.2018.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_text", length = 500)
    private String shortText;

    @Column(name = "full_text", length = 10000)
    private String fullText;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference("comment-manage")
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getShortText() {
        return shortText;
    }

    public Post setShortText(String shortText) {
        this.shortText = shortText;
        return this;
    }

    public String getFullText() {
        return fullText;
    }

    public Post setFullText(String fullText) {
        this.fullText = fullText;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public PostDto toDto() {
        return PostDto.build()
                .withId(id)
                .withTitle(title)
                .withShortText(shortText)
                .withFullText(fullText)
                .withComments(comments)
                .please();
    }
}
