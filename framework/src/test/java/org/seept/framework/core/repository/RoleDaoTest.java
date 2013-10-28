package org.seept.framework.core.repository;

import org.junit.Test;
import org.seept.framework.core.entity.Role;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author: Quan
 * @Description:
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class RoleDaoTest extends TransactionalTestCase {

    private static Logger logger = LoggerFactory.getLogger(RoleDaoTest.class);

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testFindAll() {
        logger.info("roleDao test find all begin");
        List<Role> roles = (List<Role>) roleDao.findAll();
        logger.info("list size :"+roles.size());

        /*roleDao.delete("R001");
        roles = (List<Role>) roleDao.findAll();
        logger.info("list size :"+roles.size());*/

        Role role = new Role();
        role.setName("nnb");

        roleDao.save(role);

        roles = (List<Role>) roleDao.findAll();
        logger.info("list size2 :"+roles.size());

        for(Role role1 : roles) {
            System.out.println("--------"+role1.getName());
        }

        logger.info("roleDao test find all end");
    }

}
