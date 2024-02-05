package org.CERN.bounties.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 5 and 20 characters.")
    private String userName;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters.")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
