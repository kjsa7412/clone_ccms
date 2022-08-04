package com.kjsa.clone_ccms.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "reg_dt", updatable = false)
    private Instant regDt;

    @Column(name = "reg_user_id", length = 20)
    private String regUserId;

    @Column(name = "reg_user_ip", length = 20)
    private String regUserIp;

    @LastModifiedDate
    @Column(name = "update_dt")
    private Instant updateDt;

    @Column(name = "update_user_id", length = 20)
    private String updateUserId;

    @Column(name = "update_user_ip", length = 20)
    private String updateUserIp;
}
