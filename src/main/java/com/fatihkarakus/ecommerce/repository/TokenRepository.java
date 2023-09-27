package com.fatihkarakus.ecommerce.repository;

import com.fatihkarakus.ecommerce.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
}
