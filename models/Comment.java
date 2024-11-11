package com.blog.siglo21.trabajo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;


    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore  // Evita que la relación post sea serializada en cada comentario
    private Post post;
    // Constructores
    public Comment() {}


}

