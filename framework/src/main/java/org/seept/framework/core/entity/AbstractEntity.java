package org.seept.framework.core.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author : lihaoquan
 */
@MappedSuperclass
public class AbstractEntity {

    protected String id;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 采用Hibernate对JPA实体的支持;
     * 使用了Hibernate对主键生成策略的扩展,通过Hibernate对@GenericGenerator的实现
     */
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
