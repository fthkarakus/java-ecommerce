package com.fatihkarakus.ecommerce.service;

import com.fatihkarakus.ecommerce.model.AuthenticationToken;
import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    TokenRepository tokenRepository;
    public void saveCOnfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
