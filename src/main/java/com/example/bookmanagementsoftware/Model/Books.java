package com.example.bookmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loanSet;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
