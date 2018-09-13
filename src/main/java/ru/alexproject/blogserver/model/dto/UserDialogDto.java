package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Dialog;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.domain.UserDialog;

import java.io.Serializable;

public class UserDialogDto implements Serializable {

    private UserDialogDto() {
    }

    private Long id;

    private User user;

    private Dialog dialog;

    private String text;

    private UserDialogDto(Long id, User user, Dialog dialog, String text) {
        this.id = id;
        this.user = user;
        this.dialog = dialog;
        this.text = text;
    }

    public static class UserDialogBuilder {

        private Long id;

        private User user;

        private Dialog dialog;

        private String text;

        public UserDialogBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDialogBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public UserDialogBuilder withDialog(Dialog dialog) {
            this.dialog = dialog;
            return this;
        }

        public UserDialogBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public UserDialogDto please() {
            return new UserDialogDto(id, user, dialog, text);
        }
    }

    public UserDialog toEntity() {
        return new UserDialog()
                .setId(id)
                .setText(text)
                .setDialog(dialog)
                .setUser(user);
    }

    public static UserDialogBuilder build() {
        return new UserDialogBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
