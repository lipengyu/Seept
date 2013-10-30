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
     * ����Hibernate��JPAʵ���֧��;
     * ʹ����Hibernate���������ɲ��Ե���չ,ͨ��Hibernate��@GenericGenerator��ʵ��
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
