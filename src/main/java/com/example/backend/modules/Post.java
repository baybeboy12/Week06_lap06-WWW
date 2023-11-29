package com.example.backend.modules;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean published;
    private String content;
    private String metaTitle;
    private String summary;
    private Instant createAt;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "authorId",nullable = false)
    private User author;
    private Instant updateAt;
    private Instant publishedAt;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Post parent;

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    public Post(boolean published, String content, String metaTitle, String summary, Instant createAt, String title, User author, Instant updateAt, Instant publishedAt, Set<Post> posts, Post parent, Set<PostComment> postComments) {
        this.published = published;
        this.content = content;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createAt = createAt;
        this.title = title;
        this.author = author;
        this.updateAt = updateAt;
        this.publishedAt = publishedAt;
        this.posts = posts;
        this.parent = parent;
        this.postComments = postComments;
    }
}
