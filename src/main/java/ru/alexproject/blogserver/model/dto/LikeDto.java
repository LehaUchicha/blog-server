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
public class LikeDto implements Serializable {

    private Long id;

    private UserDto user;

    private PostDto post;

    private CommentDto comment;
}
