package ru.alexproject.blogserver.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"roles", "dialogs", "comments"})
@ToString(exclude = {"roles", "dialogs", "comments"})
public class UserDto implements Serializable {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    @JsonIgnore
    private Set<RoleDto> roles;

    @JsonIgnore
    private Set<UserDialogDto> dialogs;

    @JsonIgnore
    private Set<CommentDto> comments;
}
