package com.kjsa.clone_ccms.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sy_user_info")
public class SyUserInfo extends BaseEntity implements UserDetails {

    @Id
    @Column(name = "user_id", nullable = false, length = 20)
    private String id;

    @Column(name = "user_nm", nullable = false, length = 100)
    private String userNm;

    @Column(name = "comp_cd", nullable = false, length = 5)
    private String compCd;

    @Column(name = "pwd", nullable = false, length = 256)
    private String pwd;

    @Column(name = "dept_cd", length = 10)
    private String deptCd;

    @Column(name = "belo_comp_nm", length = 30)
    private String beloCompNm;

    @Column(name = "posi_nm", length = 30)
    private String posiNm;

    @Column(name = "tel_no", length = 15)
    private String telNo;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "user_gb_cd", nullable = false, length = 10)
    private String userGbCd;

    @Column(name = "ente_dd", length = 8)
    private String enteDd;

    @Column(name = "reti_dd", length = 8)
    private String retiDd;

    @Column(name = "use_yn", nullable = false, length = 1)
    private String useYn;

    @Column(name = "comu_mngr_yn", length = 1)
    private String comuMngrYn;

    @Column(name = "chei_yn", length = 1)
    private String cheiYn;

    @Column(name = "bigo", length = 500)
    private String bigo;

    @Column(name = "dueup_dd", length = 8)
    private String dueupDd;

    @Column(name = "fnl_pwd_chng_dd", length = 8)
    private String fnlPwdChngDd;

    @Column(name = "pwd_rst_yn", length = 1)
    private String pwdRstYn;

    @Column(name = "pwd_lk_yn", length = 1)
    private String pwdLkYn;

    @Column(name = "frst_login_yn", length = 1)
    private String frstLoginYn;

    @Column(name = "login_flr_tms", precision = 8)
    private BigDecimal loginFlrTms;


    //
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.id;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getPassword() { return this.pwd; }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}