package com.example.bookmanagementsoftware.Repositroy;

import com.example.bookmanagementsoftware.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
