package com.AndrzejJarosz.module.user;

import com.AndrzejJarosz.module.user.custom.CompanyConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {

    @NotBlank(message = "name is required")
    private String name;
    @NotNull(message = "surname is required")
    private String surname;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @CompanyConstraint
    private String company;

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
