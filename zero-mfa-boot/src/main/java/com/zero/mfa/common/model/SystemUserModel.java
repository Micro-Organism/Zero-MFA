package com.zero.mfa.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserModel {
    private String login;
    private String password;
    private String secret;
}
