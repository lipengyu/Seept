package org.seept.framework.test.springtest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author: Quan
 * @Description: ��ͨ�ĵ�Ԫ��������
 *
 * ��Ӧ������������������ʱ��,�ἤ��test-Profilesע���µ�bean
 *
 * ��case������ͨ���߼���Ԫ����
 */
@ActiveProfiles(ProfilesInfo.TESTING)
public class NomalTestCase extends AbstractJUnit4SpringContextTests {

}
