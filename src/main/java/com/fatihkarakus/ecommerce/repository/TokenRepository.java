package com.fatihkarakus.ecommerce.repository;

import com.fatihkarakus.ecommerce.model.AuthenticationToken;
import com.fatihkarakus.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);
}
