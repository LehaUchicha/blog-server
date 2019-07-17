package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dialogs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Dialog implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dialog_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dialog")
    @JsonManagedReference("dialog-manager")
    private Set<UserDialog> users;
}