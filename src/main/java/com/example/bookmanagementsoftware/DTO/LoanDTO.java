package com.example.bookmanagementsoftware.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class LoanDTO {

    private Integer userId;
    private Integer booksId;
    private String name;
    private String genre;
}
