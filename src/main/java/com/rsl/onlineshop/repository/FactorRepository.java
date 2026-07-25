package com.rsl.onlineshop.repository;

import com.rsl.onlineshop.model.Factor;
import com.rsl.onlineshop.model.Payed;
import com.rsl.onlineshop.model.UserssDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor,Long> {
    Optional<Factor> findByUserssDetailsAndPayed(UserssDetails userssDetails,Payed payed);
}
