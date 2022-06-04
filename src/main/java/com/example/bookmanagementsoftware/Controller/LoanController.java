package com.example.bookmanagementsoftware.Controller;

import com.example.bookmanagementsoftware.DTO.Api;
import com.example.bookmanagementsoftware.DTO.LoanDTO;
import com.example.bookmanagementsoftware.Model.Loan;
import com.example.bookmanagementsoftware.Service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {
    Logger logger = LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService ;

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("getLoans");
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoans());
    }

    @PostMapping
    private ResponseEntity<Api> addLoans(@RequestBody Loan loan){
        logger.info("addLoans");
        return ResponseEntity.status(HttpStatus.OK).body(new Api("User added !", 200));
    }

    @PostMapping("/lend/{bookId}/{userId}")
    public ResponseEntity<Api> lendBooks(@RequestBody LoanDTO loanDTO){
        logger.info("lend");
        loanService.lend(loanDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Lend completed !", 200));
    }

    @DeleteMapping("/delete/{booksId}/{loanId}")
    public ResponseEntity<Api> lendedDBooks(@PathVariable Integer booksId, @PathVariable Integer loanId){
        logger.info("lend");
        loanService.lended(booksId, loanId);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Lend completed !", 200));
    }
}
