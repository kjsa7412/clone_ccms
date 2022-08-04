package com.kjsa.clone_ccms.service.impl;

import com.kjsa.clone_ccms.common.CommonResponse;
import com.kjsa.clone_ccms.config.security.JwtTokenProvider;
import com.kjsa.clone_ccms.controller.LoginController;
import com.kjsa.clone_ccms.data.dao.SyUserInfoDao;
import com.kjsa.clone_ccms.data.dto.SignInResultDto;
import com.kjsa.clone_ccms.data.dto.SignUpResultDto;
import com.kjsa.clone_ccms.data.dto.SyUserInfoDto;
import com.kjsa.clone_ccms.data.entity.SyUserInfo;
import com.kjsa.clone_ccms.data.repository.UserRepository;
import com.kjsa.clone_ccms.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private SyUserInfoDao syUserInfoDao; //사용자정보 조회
    private JwtTokenProvider jwtTokenProvider;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public LoginServiceImpl(SyUserInfoDao syUserInfoDao, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.syUserInfoDao = syUserInfoDao;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SyUserInfoDto getUserInfo(String userName)
    {
        LOGGER.info("[getUserInfo] 시작");
        LOGGER.info("[getUserInfo] userName : {}", userName);
        SyUserInfoDto syUserInfoDto;
        syUserInfoDto = syUserInfoDao.selectByPrimaryKey(userName);
        return syUserInfoDto;
    }

    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role) {
        LOGGER.info("[signUp] 시작");
        //LOGGER.info("[signUp] id : {}, password : {}, name : {}, role : {}", id, password, name, role);
        //LOGGER.info("[signUp] encodedPassword : {}", passwordEncoder.encode(password));

        //
        SyUserInfo user;

        if(role.equalsIgnoreCase("admin")){
            user = SyUserInfo.builder()
                .id(id)
                .userNm(id)
                .compCd("01")
                .pwd(passwordEncoder.encode(password))
                .userGbCd("ROLE_ADMIN")
                .useYn("Y")
                .roles(Collections.singletonList("ROLE_ADMIN"))
                .build();
        }else{
            user = SyUserInfo.builder()
                .id(id)
                .userNm(id)
                .compCd("01")
                .pwd(passwordEncoder.encode(password))
                .userGbCd("ROLE_USER")
                .useYn("Y")
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        }

        SyUserInfo SavedUser = userRepository.save(user);

        //
        SignUpResultDto signUpResultDto = new SignInResultDto();

        if(!SavedUser.getId().isBlank()){
            LOGGER.info("[signUp] 정상 처리");
            setSuccessResult(signUpResultDto);

        }else{
            LOGGER.info("[signUp] 실패 처리");
            setFailResult(signUpResultDto);
        }

        return signUpResultDto;
    }

    @Override
    public SignInResultDto signIn(String id, String password) throws RuntimeException {
        LOGGER.info("[signIn] 시작");

        //
        SyUserInfo user = userRepository.findById(id);

        //
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException();
        }

        //
        SignInResultDto signInResultDto = SignInResultDto.builder().token(jwtTokenProvider.createToken(user.getId(), user.getRoles())).build();

        //
        setSuccessResult(signInResultDto);

        return signInResultDto;
    }


    private void setSuccessResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // 결과 모델에 api 요청 실패 데이터를 세팅해주는 메소드
    private void setFailResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }
}
