package ru.alexproject.blogserver.model.domain;

import ru.alexproject.blogserver.model.dto.LikeDto;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = true)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(optional = true)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Long getId() {
        return id;
    }

    public Like setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Like setUser(User user) {
        if (user != null)
            this.user = user;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Like setPost(Post post) {
        if (post != null)
            this.post = post;
        return this;
    }

    public Comment getComment() {
        return comment;
    }

    public Like setComment(Comment comment) {
        this.comment = comment;
        return this;
    }

    public LikeDto toDto() {
        return LikeDto.build()
                .setId(id)
                .setUser(user)
                .setPost(post)
                .setComment(comment)
                .please();
    }
}
