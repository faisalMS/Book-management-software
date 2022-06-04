package com.example.bookmanagementsoftware.Controller;

import com.example.bookmanagementsoftware.DTO.Api;
import com.example.bookmanagementsoftware.Model.Books;
import com.example.bookmanagementsoftware.Service.BooksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BooksController {

    Logger logger = LoggerFactory.getLogger(BooksController.class);

    private final BooksService booksService;

    @GetMapping
    public ResponseEntity<List<Books>> getBooks(){
        logger.info("getBooks");

        return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks());
    }

    @PostMapping
    private ResponseEntity<Api> addBooks(@RequestBody @Valid Books books){
        logger.info("addBooks");
        booksService.addBooks(books);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("User added !", 200));
    }
}
