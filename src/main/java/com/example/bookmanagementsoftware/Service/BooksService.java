package com.example.bookmanagementsoftware.Service;

import com.example.bookmanagementsoftware.Model.Books;
import com.example.bookmanagementsoftware.Model.User;
import com.example.bookmanagementsoftware.Repositroy.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;


    public List<Books> getBooks() {

        return booksRepository.findAll();
    }

    public void addBooks(Books books) {
        booksRepository.save(books);
    }
}
