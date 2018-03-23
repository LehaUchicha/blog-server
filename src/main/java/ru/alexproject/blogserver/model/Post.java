package ru.alexproject.blogserver.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String title;
    private String text;
}
