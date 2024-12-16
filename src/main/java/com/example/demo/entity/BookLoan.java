package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "book_loan")
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "loan_date")
    private Date loanDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;


}
