package com.collectors.admin.emailAuth.interfaces;

public interface EmailCodeService {
    String sendSimpleMessage(String to) throws Exception;
}
