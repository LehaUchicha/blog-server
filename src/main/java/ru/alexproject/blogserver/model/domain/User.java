package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.alexproject.blogserver.model.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-dialog-manage")
    private Set<UserDialog> dialogs;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference("user-manage")
    private Set<Comment> comments;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public User setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Set<UserDialog> getDialogs() {
        return dialogs;
    }

    public User setDialogs(Set<UserDialog> dialogs) {
        this.dialogs = dialogs;
        return this;
    }

    public UserDto toDto() {
        return UserDto.build()
                .withComments(comments)
                .withDialogs(dialogs)
                .withFirstName(firstName)
                .withId(id)
                .withLastName(lastName)
                .withPassword(password)
                .withRoles(roles)
                .withUsername(username)
                .please();
    }
}
