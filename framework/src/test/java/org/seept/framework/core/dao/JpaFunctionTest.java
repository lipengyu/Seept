package org.seept.framework.core.dao;

import org.junit.Test;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

/**
 * @author: Quan
 * @Description:Jpa的基本功能测试用例
 *
 * 本测试单元继承了带事务方式的TestCase
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})//引入上下文环境
public class JpaFunctionTest extends TransactionalTestCase {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void checkEntities() throws Exception{
        Metamodel model = em.getEntityManagerFactory().getMetamodel();
        System.out.println("==================entities size :" + model.getEntities().size());
        for(EntityType entityType : model.getEntities()) {
            String entityName = entityType.getName();
            List list = em.createQuery("select obj from " + entityName + " obj").getResultList();
            System.out.println("query list size ====="+list.size());
        }
    }

}
