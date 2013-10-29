package org.seept.framework.core.repository;

import org.junit.Test;
import org.seept.framework.core.entity.UserRole;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author : lihaoquan
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserRoleDaoTest extends TransactionalTestCase {

    private static Logger logger = LoggerFactory.getLogger(UserRoleDaoTest.class);

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void testQuery() {

        List<UserRole> userRoles = (List<UserRole>) userRoleDao.findAll();

        logger.info("userroles : "+userRoles.size());

        List<UserRole> userRoles1 = userRoleDao.findByUserid("U002");

        logger.info("findbyUserid :"+userRoles1.size());

    }

}
