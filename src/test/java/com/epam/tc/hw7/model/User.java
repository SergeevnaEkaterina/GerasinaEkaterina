package com.epam.tc.hw7.model;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class User extends DataClass<User> {
    private String login;
    private String password;
    private String userName;
}
