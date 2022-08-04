package com.kjsa.clone_ccms.service;

import com.kjsa.clone_ccms.data.dto.SignInResultDto;
import com.kjsa.clone_ccms.data.dto.SignUpResultDto;
import com.kjsa.clone_ccms.data.dto.SyUserInfoDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface LoginService {

    public SyUserInfoDto getUserInfo(String userName);

    SignUpResultDto signUp(String id, String password, String name, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
