package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 21.03.2018.
 */
@Entity
@Table(name = "posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"likes", "comments"})
@ToString(exclude = {"likes", "comments"})
public class Post implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
    @JsonIgnore
    private Set<Like> likes;
}