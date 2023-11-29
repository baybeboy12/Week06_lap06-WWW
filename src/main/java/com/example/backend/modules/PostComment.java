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
@Table(name = "post_comment")
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();
    private Boolean published;
    private String content;
    private Instant publishedAt;
    private Instant createAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public PostComment(String title, Post post, Set<PostComment> postComments, Boolean published, String content, Instant publishedAt, Instant createAt, PostComment parent) {
        this.title = title;
        this.post = post;
        this.postComments = postComments;
        this.published = published;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createAt = createAt;
        this.parent = parent;
    }
}
