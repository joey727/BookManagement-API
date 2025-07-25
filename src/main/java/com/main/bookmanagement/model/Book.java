package com.main.bookmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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

    @Builder.Default
    @Column(nullable = true)
    private String borrower = null;
    @Builder.Default
    @Column(nullable = true)
    private LocalDate dueDate = null;
}
