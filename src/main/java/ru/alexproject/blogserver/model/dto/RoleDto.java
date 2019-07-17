package ru.alexproject.blogserver.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class RoleDto implements Serializable {

    private Long id;

    private String roleName;

    private String description;

    @JsonIgnore
    private Set<UserDto> users;
}