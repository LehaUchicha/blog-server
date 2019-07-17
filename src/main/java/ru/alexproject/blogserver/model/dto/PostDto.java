package ru.alexproject.blogserver.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "comments")
@ToString(exclude = "comments")
public class PostDto implements Serializable {

    private Long id;

    private String title;

    private String shortText;

    private String fullText;

    @JsonIgnore
    private List<CommentDto> comments;
}
