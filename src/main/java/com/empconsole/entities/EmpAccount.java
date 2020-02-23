package com.empconsole.entities;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "emp_account")
@NamedQuery(name = "EmpAccount.findByUserName", query = "select e FROM EmpAccount e WHERE  Upper(e.userName) = Upper( :pUserName )  ")
@NamedQuery(name = "EmpAccount.findByEmail", query = "select e FROM EmpAccount e WHERE  Upper(e.email) = Upper( :pEmail )  ")
public class EmpAccount implements UserDetails {
    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long empId;

    @Column(name = "USER_NAME")
    public String userName;
    @Column(name = "PASSWORD")
    public String password;

    @Column(name = "email")
    public String email;

    @Column(name = "IS_ACTIVE")
    public int isActive;

    @Transient
    public String token;


    public EmpAccount() {
    }

    public EmpAccount(long empId, String userName, String password, String email, int isActive, String token) {
        this.empId = empId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.token = token;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isActive == 1 ? true : false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
