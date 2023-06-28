package com.tsti.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Debe completar el documento")
    private Long document;
    @NotNull(message = "Debe completar el nombre")
    private String firstName;
    @NotNull(message = "Debe completar el apellido")
    private String lastName;
    @NotNull(message = "Debe completar la dirección")
    private String address;
    @NotNull(message = "Debe completar el email")
    @Email(message = "el email debe tener un formato válido. Ej: test@test.com")
    private String email;
    @Column(columnDefinition = "DATE")
    @NotNull(message = "Debe completar la fecha de nacimiento")
    private String  birthDate;
    private String passportNumber;
    @Column(columnDefinition = "DATE")
    private String  passportExpirationDate;

    public Client() {
    }

    public Client(Long id, Long document, String firstName, String lastName, String address, String email, String birthDate) {
        this.id = id;
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Client(Long id, Long document, String firstName, String lastName, String address, String email, String birthDate, String passportNumber, String passportExpirationDate) {
        this.id = id;
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.passportExpirationDate = passportExpirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate  getBirthDate() {
        if (birthDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(birthDate, formatter);
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            this.birthDate = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.birthDate = birthDate.format(formatter);
        }
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportExpirationDate() {
        if (passportExpirationDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(passportExpirationDate, formatter);
    }

    public void setPassportExpirationDate(LocalDate passportExpirationDate) {
        if (passportExpirationDate == null) {
            this.passportExpirationDate = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.passportExpirationDate = passportExpirationDate.format(formatter);
        }
    }
}
