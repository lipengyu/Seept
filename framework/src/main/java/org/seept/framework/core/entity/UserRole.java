package org.seept.framework.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : lihaoquan
 */
@Entity
@Table(name = "s_user_role")
public class UserRole extends AbstractEntity {

    private String userid;

    private String roleid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
