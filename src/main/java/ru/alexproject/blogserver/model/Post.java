package ru.alexproject.blogserver.model;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Alex on 21.03.2018.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Post {

    private String id;
    private String title;
    private String text;
}
