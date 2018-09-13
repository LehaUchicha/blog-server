package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.alexproject.blogserver.model.dto.CommentDto;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Post post;

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    public CommentDto toDto() {
        return CommentDto.build()
                .withId(id)
                .withText(text)
                .withAuthor(author)
                .withPost(post)
                .please();
    }
}
