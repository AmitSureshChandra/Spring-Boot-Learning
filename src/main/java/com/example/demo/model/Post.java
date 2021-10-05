package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "blogger_id")

    private Blogger blogger;

    public Post() {
    }
}
