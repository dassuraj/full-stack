package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_year")
    private Date publicationYear;

    @Column(name = "publisher")
    private String publisher;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "b_id"),
            inverseJoinColumns = @JoinColumn(name = "a_id")
    )
    private List<Author> authors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "b_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    private List<Category> categories;

}
