package com.zero.mfa.service;


public interface TotpService {
    boolean verifyCode(String totpCode, String secret);
}

