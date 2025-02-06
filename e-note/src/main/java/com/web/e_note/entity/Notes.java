package com.web.e_note.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", columnDefinition = "TEXT")
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT" )
    @NotBlank(message = "Content cannot be empty")
    private String content;
//
//    @Column(name = "time")
//    private LocalDateTime time;

}
