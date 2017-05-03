package com.pollub.model;

import com.pollub.utils.LocalDateTimeConverter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Eryk on 2017-05-03.
 */

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    @NotBlank
    @Lob
    @Column(nullable = false)
    private String commentText;

    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime commentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }
}
