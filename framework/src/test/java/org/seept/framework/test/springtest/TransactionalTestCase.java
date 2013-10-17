package org.seept.framework.test.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

/**
 * @author: Quan
 * @Description: 具备事务能力的单元测试用例
 */
@ActiveProfiles(ProfilesInfo.TESTING)
public class TransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {

    protected DataSource dataSource;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
        this.dataSource = dataSource;
    }
}
