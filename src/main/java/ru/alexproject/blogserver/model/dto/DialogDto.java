package ru.alexproject.blogserver.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class DialogDto implements Serializable {

    private Long id;

    private String name;

    @JsonIgnore
    private Set<UserDialogDto> users;
}