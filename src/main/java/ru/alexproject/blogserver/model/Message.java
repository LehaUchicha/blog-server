package ru.alexproject.blogserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "from_id")
    @JsonBackReference
    private User fromId;

    @ManyToOne
    @JoinColumn(name = "to_id")
    @JsonBackReference
    private User toId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getFromId() {
        return fromId;
    }

    public void setFromId(User fromId) {
        this.fromId = fromId;
    }

    public User getToId() {
        return toId;
    }

    public void setToId(User toId) {
        this.toId = toId;
    }
}
