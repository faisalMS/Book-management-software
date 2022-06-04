package com.example.bookmanagementsoftware.Service;

import com.example.bookmanagementsoftware.DTO.LoanDTO;
import com.example.bookmanagementsoftware.Exception.InvalidIDException;
import com.example.bookmanagementsoftware.Model.Books;
import com.example.bookmanagementsoftware.Model.Loan;
import com.example.bookmanagementsoftware.Model.User;
import com.example.bookmanagementsoftware.Repositroy.BooksRepository;
import com.example.bookmanagementsoftware.Repositroy.LoanRepository;
import com.example.bookmanagementsoftware.Repositroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;


    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void addLoans(Loan loan) {
        loanRepository.save(loan);
    }

    public void lend(LoanDTO loanDTO) {
        Books books = booksRepository.findById(loanDTO.getBooksId()).
                orElseThrow(() -> new InvalidIDException("Invalid booksId !"));
        User user = userRepository.findById(loanDTO.getUserId()).
                orElseThrow(()-> new InvalidIDException("Invalid userId !"));
        Set<User> booksSet1 = new HashSet<>();
        booksSet1.add(user);
        Set<Books> booksSet = new HashSet<>();
        booksSet.add(books);
        Loan loan = new Loan(null, loanDTO.getBooksId(), loanDTO.getUserId(),booksSet, user);
        loanRepository.save(loan);
    }

    public String lended(Integer bookId, Integer loanId) {
        Books books = booksRepository.findById(bookId).
                orElseThrow(() -> new InvalidIDException("Invalid bookId !"));
        Loan loan = loanRepository.findById(loanId).
                orElseThrow(() -> new InvalidIDException("Invalid loanId !")) ;
        Set<Books> booksSet = loan.getBooksSet();
        booksSet.remove(books);
        loanRepository.save(loan);
        booksRepository.save(books);
        return "complete";
    }

}
