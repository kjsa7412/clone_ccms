package com.kjsa.clone_ccms.data.dao;

import com.kjsa.clone_ccms.data.dto.SyUserInfoDto;


public interface SyUserInfoDao {

    public SyUserInfoDto selectByPrimaryKey(String userId);
}
