package com.epam.tc.hw6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String login;
    private String password;
    private String userName;
}
