package com.mybatistest.domain;

/**
 * Created by zhang_jian on 2017/12/15.
 */
public class User {
    private Integer id;
    private String username;
    private String phone;
    private String address;
    private String sex;
    private String email;
    private String password;
    private String createDate;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", username = " + username +
                ", phone = " + phone +
                ", address = " + address +
                ", sex = " + sex +
                ", email = " + email +
                ", creatdate = " + createDate + "}";
    }
}
