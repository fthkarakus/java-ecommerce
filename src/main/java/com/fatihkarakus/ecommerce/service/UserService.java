package com.fatihkarakus.ecommerce.service;

import com.fatihkarakus.ecommerce.dto.ResponseDto;
import com.fatihkarakus.ecommerce.dto.user.SignupDto;
import com.fatihkarakus.ecommerce.exceptions.CustomException;
import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.repository.UserRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public ResponseDto signUp(SignupDto signupDto) {
        // check if user is already present
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            // we have an user
            throw new CustomException("user already present");
        }

        // hash the password

        String encryptedpassword = signupDto.getPassword();

        try {
            encryptedpassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedpassword);

        userRepository.save(user);
        // save the user

        // create the token
        ResponseDto responseDto = new ResponseDto("success","user created");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return hash;
    }
}
