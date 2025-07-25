package com.main.bookmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    @Builder.Default
    private boolean isAvailable = true;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    @JsonBackReference
    private Borrower borrower;
    private LocalDate dueDate;
}
