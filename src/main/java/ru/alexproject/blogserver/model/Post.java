package ru.alexproject.blogserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Alex on 21.03.2018.
 */

@Getter
@Setter
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String text;
}
