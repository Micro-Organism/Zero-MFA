package com.zero.mfa.service.impl;

import com.zero.mfa.common.model.SystemUserModel;
import com.zero.mfa.service.SystemUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    private static final List<SystemUserModel> SYSTEM_USER_MODELS = new ArrayList<>();
    private static final int SECRET_SIZE = 10;

    @Value("${2fa.enabled}")
    private boolean isTwoFaEnabled;

    @Override
    public SystemUserModel register(String login, String password) {
        SystemUserModel systemUserModel = new SystemUserModel(login, password, generateSecret());
        SYSTEM_USER_MODELS.add(systemUserModel);

        return systemUserModel;
    }

    @Override
    public Optional<SystemUserModel> findUser(String login, String password) {
        return SYSTEM_USER_MODELS.stream()
                .filter(systemUserModel -> systemUserModel.getLogin().equals(login) && systemUserModel.getPassword().equals(password))
                .findFirst();
    }

    private String generateSecret() {
        return RandomStringUtils.random(SECRET_SIZE, true, true).toUpperCase();
    }
}