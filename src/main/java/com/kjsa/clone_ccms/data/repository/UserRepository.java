package com.kjsa.clone_ccms.data.repository;

import com.kjsa.clone_ccms.data.entity.SyUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<SyUserInfo, Long> {

    SyUserInfo findById(String name);
}
