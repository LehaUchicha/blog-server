package ru.alexproject.blogserver.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "comments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="likes")
@ToString(exclude = "likes")
public class Comment implements Serializable{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn
    @JsonBackReference("user-manage")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference("comment-manage")
    private Post post;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
    @JsonIgnore
    private Set<Like> likes;
}