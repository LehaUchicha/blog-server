package ru.alexproject.blogserver.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex on 21.03.2018.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "shortText", length = 500)
    private String shortText;
    @Column(name = "fullText", length = 10000)
    private String fullText;
    @Column(name = "likes")
    private Integer likes;

    @OneToMany
    private List<Comment> comments;
}
