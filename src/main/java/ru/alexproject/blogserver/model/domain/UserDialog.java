package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_dialog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDialog implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference("user-dialog-manage")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dialog_id", referencedColumnName = "id")
    @JsonBackReference("dialog-manager")
    private Dialog dialog;

    @Column(name = "text")
    private String text;
}