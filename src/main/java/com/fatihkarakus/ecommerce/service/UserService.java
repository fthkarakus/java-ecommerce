package com.fatihkarakus.ecommerce.service;

import com.fatihkarakus.ecommerce.dto.ResponseDto;
import com.fatihkarakus.ecommerce.dto.user.SigninDto;
import com.fatihkarakus.ecommerce.dto.user.SigninResponseDto;
import com.fatihkarakus.ecommerce.dto.user.SignupDto;
import com.fatihkarakus.ecommerce.exceptions.AuthenticationFailException;
import com.fatihkarakus.ecommerce.exceptions.CustomException;
import com.fatihkarakus.ecommerce.model.AuthenticationToken;
import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
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
    @Autowired
    AuthenticationService authenticationService;
    @Transactional
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
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveCOnfirmationToken(authenticationToken);

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

    public SigninResponseDto signIn(SigninDto signinDto) {
        // find user by email
        User user = userRepository.findByEmail(signinDto.getEmail());
        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("user is not valid");
        }

        // hash the password
        try {
            if(!user.getPassword().equals(hashPassword(signinDto.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // compare the password in DB

        // if password match

        AuthenticationToken token = authenticationService.getToken(user);

        // retrive the token

        if (Objects.isNull(token)) {
            throw  new CustomException("token is not present");
        }

        return new SigninResponseDto("success", token.getToken());
        // return response
    }
}
