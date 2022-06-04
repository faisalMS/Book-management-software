package com.example.bookmanagementsoftware.Repositroy;

import com.example.bookmanagementsoftware.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
