package com.kjsa.clone_ccms.data.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SyUserInfoDto {

    private String userId;

    private String userNm;

    private String compCd;

    private String pwd;

    private String deptCd;

    private String beloCompNm;

    private String posiNm;

    private String telNo;

    private String email;

    private String userGbCd;

    private String enteDd;

    private String retiDd;

    private String useYn;

    private String comuMngrYn;

    private String cheiYn;

    private String bigo;

    private String dueupDd;

    private String fnlPwdChngDd;

    private String pwdRstYn;

    private String pwdLkYn;

    private String frstLoginYn;

    private Integer loginFlrTms;

    private String regUserId;

    private String regUserIp;

    private String updateUserId;

    private String updateUserIp;

}