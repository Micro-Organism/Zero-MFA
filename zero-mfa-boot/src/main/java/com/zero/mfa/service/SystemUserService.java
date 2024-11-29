package com.zero.mfa.service;

import com.zero.mfa.common.model.SystemUserModel;

import java.util.Optional;


public interface SystemUserService {

    SystemUserModel register(String login, String password);

    Optional<SystemUserModel> findUser(String login, String password);
}