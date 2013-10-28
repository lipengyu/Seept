package org.seept.framework.core.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Quan
 * @Description:½ÇÉ«¶ÔÏó
 */
@Entity
@Table(name = "s_role")
public class Role extends AbstractEntity {

    private String name;

    private String roledesc;

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }
}
