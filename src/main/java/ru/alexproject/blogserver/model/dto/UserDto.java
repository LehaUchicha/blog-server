package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Comment;
import ru.alexproject.blogserver.model.domain.Role;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.domain.UserDialog;

import java.io.Serializable;
import java.util.Set;

public class UserDto implements Serializable{

    private UserDto() {
    }

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Set<Role> roles;

    private Set<UserDialog> dialogs;

    private Set<Comment> comments;

    public UserDto(Long id, String username, String password, String firstName, String lastName, Set<Role> roles, Set<UserDialog> dialogs, Set<Comment> comments) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.dialogs = dialogs;
        this.comments = comments;
    }

    public static class UserDtoBuilder {

        private Long id;

        private String username;

        private String password;

        private String firstName;

        private String lastName;

        private Set<Role> roles;

        private Set<UserDialog> dialogs;

        private Set<Comment> comments;

        public UserDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDtoBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDtoBuilder withRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public UserDtoBuilder withDialogs(Set<UserDialog> dialogs) {
            this.dialogs = dialogs;
            return this;
        }

        public UserDtoBuilder withComments(Set<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public UserDto please() {
            return new UserDto(id, username, password, firstName, lastName, roles, dialogs, comments);
        }
    }

    public static UserDtoBuilder build() {
        return new UserDtoBuilder();
    }

    public User toEntity() {
        return new User()
                .setId(id)
                .setPassword(password)
                .setComments(comments)
                .setDialogs(dialogs)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setRoles(roles)
                .setUsername(username);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<UserDialog> getDialogs() {
        return dialogs;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setDialogs(Set<UserDialog> dialogs) {
        this.dialogs = dialogs;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
