package ru.alexproject.blogserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto implements Serializable {

    private Long id;

    private String text;

    private UserDto author;

    private PostDto post;
}
