package com.lewandowski.validation;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class UserValidator {

    private static final String REQUIRED = "is required";

    @NotEmpty(message = REQUIRED)
    @Size(min = 4, max = 80, message = "Username must be between 4 and 80 characters")
    private String username;

    @NotEmpty(message = REQUIRED)
    @Size(min = 4, max = 80, message = "Password must be between 4 and 80 characters")
    private String password;

    @NotEmpty(message = REQUIRED)
    @Size(min = 4, max = 80, message = "Password must be between 4 and 80 characters")
    private String matchingPassword;

    @NotEmpty(message = REQUIRED)
    @Size(min = 1, max = 40, message = "First name must be between 1 and 40 characters")
    private String firstName;

    @NotEmpty(message = REQUIRED)
    @Size(min = 1, max = 40, message = "Last name must be between 1 and 40 characters")
    private String lastName;

    @NotEmpty(message = REQUIRED)
    @Email(message = "Must be an email")
    private String email;

    @NotEmpty(message = REQUIRED)
    @Digits(fraction = 0, integer = 13, message = "Must be phone number")
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
