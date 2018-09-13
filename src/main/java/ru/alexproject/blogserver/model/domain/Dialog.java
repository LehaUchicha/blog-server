package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.alexproject.blogserver.model.dto.DialogDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dialogs")
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dialog_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dialog")
    @JsonManagedReference
    private Set<UserDialog> users;

    public Long getId() {
        return id;
    }

    public Dialog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dialog setName(String name) {
        this.name = name;
        return this;
    }

    public Set<UserDialog> getUsers() {
        return users;
    }

    public Dialog setUsers(Set<UserDialog> users) {
        this.users = users;
        return this;
    }

    public DialogDto toDto() {
        return DialogDto.build()
                .withId(id)
                .withName(name)
                .withUsers(users)
                .please();
    }
}
