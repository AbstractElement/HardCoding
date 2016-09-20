package com.application.service.protect;


import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 19.09.2016.
 */

@Component
public class ProtectedPassword {
    private String protect(String pass){
        byte[] newPass = pass.getBytes();
        for (int i = 0; i < newPass.length; i++)
            newPass[i] += i;
        StringBuilder builder = new StringBuilder();
        for(byte symb : newPass)
            builder.append((char)symb);
        return builder.toString();
    }

    public String goProtected(String pass){
        return protect(pass);
    }
}
