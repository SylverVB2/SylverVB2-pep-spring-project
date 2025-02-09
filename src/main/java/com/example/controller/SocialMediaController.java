package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling account-related operations such as registration and login.
 * Provides endpoints for user registration and login authentication.
 */
@RestController
public class SocialMediaController {
    private final AccountService accountService;

    /**
     * Constructor for SocialMediaController, which injects the AccountService.
     * 
     * @param accountService The service that handles account registration and login logic.
     */
    public SocialMediaController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Registers a new account using data from the request body.
     * Validates the account data, creates the account, and responds with account details.
     * 
     * @param newAccount The account data (username and password) to be used for registration.
     * @return A ResponseEntity containing the registered account details and the HTTP status.
     * 
     * The account's password should not be included in the response for security reasons.
     * In case of failure (e.g., duplicate username or invalid data), appropriate HTTP status is returned.
     * 
     * Note: RegistrationException and DuplicateUsernameException are handled globally by GlobalExceptionHandler.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account newAccount) {
        // Step 1: Attempt to register the new account using the service
        Account registeredAccount = accountService.registerAccount(newAccount);

        // Step 2: If registration is successful, return the account details with 200 Created status
        return ResponseEntity.status(HttpStatus.OK).body(registeredAccount); // or return ResponseEntity.ok(registeredAccount);
        // return ResponseEntity.status(HttpStatus.CREATED).body(registeredAccount); // In RESTful API design, 201 Created is the more appropriate status code when successfully creating a new resource
    }

     /**
     * Authenticates a user by verifying the provided username and password.
     * 
     * @param existingAccount The account data (username and password) provided by the user for login.
     * @return A ResponseEntity containing the authenticated account details and the HTTP status.
     * 
     * Note: LoginException (invalid username or password) is handled globally by GlobalExceptionHandler.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account existingAccount) {
        // Step 1: Authenticating the account using the service
        Account authenticatedAccount = accountService.login(existingAccount.getUsername(), existingAccount.getPassword());

        // Step 2: If login is successful, returning the account details with 200 OK status
        return ResponseEntity.ok(authenticatedAccount); // return ResponseEntity.status(200).body(authenticatedAccount);
    }
}