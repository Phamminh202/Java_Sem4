package com.t2010a.javashopping.entity;

import com.t2010a.javashopping.entity.base.BaseEntity;
import com.t2010a.javashopping.entity.myenum.AccountStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account extends BaseEntity {
    private int id;
    private String username;
    private String password;
    private String passwordNoHash;
    private String passwordConfirm;
    private String salt;
    private String email;
    private String phone;
    private int role;
    private AccountStatus status;
    public HashMap<String,String> errors = new HashMap<>();

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }
    public void checkValidate(){
        if (username == null || username.length() == 0) {
            errors.put("username", "Please enter username");
        }
        if (passwordNoHash == null || passwordNoHash.length() == 0) {
            errors.put("password", "Please enter password");
        }
        if (passwordNoHash != null && passwordNoHash.length() != 0 && !passwordNoHash.equals(passwordConfirm)) {
            errors.put("confirmPassword", "Password and confirm password are different!");
        }
        if (phone == null && phone.length() == 0) {
            errors.put("phone", "Please enter phone number!");
        }
        if (email == null && email.length() == 0) {
            errors.put("email", "Please enter email!");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
    public void addErrors(String key,String value){
        if (this.errors == null){
            this.errors = new HashMap<>();
        }
        this.errors.put(key,value);
    }
    public List<String> getListErrors(){
        return new ArrayList<>(errors.values());
    }

    public Account() {
        this.username = "";
        this.email = "";
        this.phone = "";
        this.role = 2;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = AccountStatus.ACTIVE;
    }

    public Account(int id, String username, String password, String salt, String email, String phone, AccountStatus status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.phone = phone;
        this.role = 2;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordNoHash() {
        return passwordNoHash;
    }

    public void setPasswordNoHash(String passwordNoHash) {
        this.passwordNoHash = passwordNoHash;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
