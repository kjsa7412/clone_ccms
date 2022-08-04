package com.kjsa.clone_ccms.data.dao.impl;

import com.kjsa.clone_ccms.data.dao.SyUserInfoDao;
import com.kjsa.clone_ccms.data.dto.SingleCountDto;
import com.kjsa.clone_ccms.data.dto.SyUserInfoDto;
import com.kjsa.clone_ccms.data.entity.SyUserInfo;
import com.kjsa.clone_ccms.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SyUserInfoDaoImpl implements SyUserInfoDao {

    private final Logger LOGGER = LoggerFactory.getLogger(SyUserInfoDaoImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public SyUserInfoDaoImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public SyUserInfoDto selectByPrimaryKey(String userId) {
        LOGGER.info("[selectByPrimaryKey] 시작");
        SyUserInfo selectedUser = userRepository.findById(userId);

        LOGGER.info("[selectByPrimaryKey] selectedUser : {}", selectedUser.getUserNm());

        SyUserInfoDto syUserInfoDto;

        syUserInfoDto = SyUserInfoDto.builder()
                .userId(selectedUser.getId())
                .userNm(selectedUser.getUserNm())
                .pwd(selectedUser.getPwd())
                .deptCd(selectedUser.getDeptCd())
                .beloCompNm(selectedUser.getBeloCompNm())
                .build();


        return syUserInfoDto;
    }

}
