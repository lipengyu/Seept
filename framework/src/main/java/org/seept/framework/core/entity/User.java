package org.seept.framework.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : lihaoquan
 * 用户实体
 */
@Entity
@Table(name = "s_user")
public class User extends AbstractEntity{


    private String name;//姓名

    private String password;//密码

    private Date registerDate;//注册日期

    private String loginName;//登陆名称


    public User() {

    }

    public User(String id) {
        this.id = id;
    }

    @NotBlank
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //定义时间日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
