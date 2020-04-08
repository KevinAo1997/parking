package com.aokai.parking.po;

import javax.persistence.*;

@Table(name = "user")
public class User {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 工号
     */
    private String code;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 头像
     */
    @Column(name = "headImg")
    private String headimg;

    /**
     * 签名描述
     */
    private String description;

    /**
     * 状态：0禁用、1启用
     */
    private Integer status;

    /**
     * 员工类型：管理员、普通员工
     */
    private String type;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取工号
     *
     * @return code - 工号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置工号
     *
     * @param code 工号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取头像
     *
     * @return headImg - 头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 设置头像
     *
     * @param headimg 头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * 获取签名描述
     *
     * @return description - 签名描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置签名描述
     *
     * @param description 签名描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态：0禁用、1启用
     *
     * @return status - 状态：0禁用、1启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0禁用、1启用
     *
     * @param status 状态：0禁用、1启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取员工类型：0管理员、1普通员工
     *
     * @return type - 员工类型：0管理员、1普通员工
     */
    public String getType() {
        return type;
    }

    /**
     * 设置员工类型：管理员、普通员工
     *
     * @param type 员工类型：管理员、普通员工
     */
    public void setType(String type) {
        this.type = type;
    }
}
