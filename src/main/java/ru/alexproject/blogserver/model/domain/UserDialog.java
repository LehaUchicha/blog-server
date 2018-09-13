package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.alexproject.blogserver.model.dto.UserDialogDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_dialog")
public class UserDialog implements Serializable{

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

    public Long getId() {
        return id;
    }

    public UserDialog setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserDialog setUser(User user) {
        this.user = user;
        return this;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public UserDialog setDialog(Dialog dialog) {
        this.dialog = dialog;
        return this;
    }

    public String getText() {
        return text;
    }

    public UserDialog setText(String text) {
        this.text = text;
        return this;
    }

    public UserDialogDto toDto() {
        return UserDialogDto.build()
                .withId(id)
                .withText(text)
                .withUser(user)
                .withDialog(dialog)
                .please();
    }
}
