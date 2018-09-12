package ru.alexproject.blogserver.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToMany(mappedBy = "id")
    @JsonManagedReference
    private Set<UserDialog> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserDialog> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDialog> users) {
        this.users = users;
    }
}
