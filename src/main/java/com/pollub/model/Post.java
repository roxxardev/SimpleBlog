package com.pollub.model;

import com.pollub.utils.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eryk on 2017-05-03.
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String tease;

    @Lob
    @Column(nullable = false)
    private String postText;

    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime postDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @OrderBy("postDate asc")
    private List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTease() {
        return tease;
    }

    public void setTease(String tease) {
        this.tease = tease;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
