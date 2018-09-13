package ru.alexproject.blogserver.model.dto;

import ru.alexproject.blogserver.model.domain.Dialog;
import ru.alexproject.blogserver.model.domain.UserDialog;

import java.io.Serializable;
import java.util.Set;

public class DialogDto implements Serializable {

    private Long id;

    private String name;

    private Set<UserDialog> users;

    private DialogDto(Long id, String name, Set<UserDialog> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public static class DialogBuilder {

        private Long id;

        private String name;

        private Set<UserDialog> users;

        public DialogBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DialogBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DialogBuilder withUsers(Set<UserDialog> users) {
            this.users = users;
            return this;
        }

        public DialogDto please() {
            return new DialogDto(id, name, users);
        }
    }

    public static DialogBuilder build() {
        return new DialogBuilder();
    }

    public Dialog toEntity() {
        return new Dialog()
                .setId(id)
                .setName(name)
                .setUsers(users);
    }
}
