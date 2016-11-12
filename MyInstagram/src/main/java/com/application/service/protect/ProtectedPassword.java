package com.application.service.protect;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class ProtectedPassword {
    private String protect(String pass){
        return DigestUtils.md5Hex(pass);
    }

    public String goProtected(String pass){
        return protect(pass);
    }
}
