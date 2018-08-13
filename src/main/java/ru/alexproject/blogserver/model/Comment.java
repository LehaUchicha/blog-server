package ru.alexproject.blogserver.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorName;

    private String text;

    @ManyToOne
    private Post post;
}
