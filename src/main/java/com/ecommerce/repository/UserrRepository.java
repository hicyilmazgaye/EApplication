package com.ecommerce.repository;

import com.ecommerce.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrRepository extends JpaRepository<Userr, Long> {
    Userr findByEmail(String email);
}
