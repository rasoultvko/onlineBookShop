package com.rsl.onlineshop.repository;

import com.rsl.onlineshop.model.UserssDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserssDetails,Long> {

    Optional<UserssDetails> findByUsername(String username);
}
