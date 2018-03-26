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
@Entity
@ToString
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "shortText")
    private String shortText;
    @Column(name = "fullText")
    private String fullText;
    @Column(name = "likes")
    private Integer likes;

    @OneToMany
    private List<Comment> comments;
}
