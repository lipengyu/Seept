package org.seept.framework.modules.webservice.jaxrs;

import org.springframework.web.client.RestTemplate;

/**
 * @author: Quan
 * @Description:
 */
public class UserFT {

    public static void main(String[] args) throws Exception {
        String resoureUrl = "http://127.0.0.1:7001/seept/cxf/jaxrs/user";

        RestTemplate restTemplate = new RestTemplate();
        String test = restTemplate.getForObject(resoureUrl+"/{id}",String.class,"我是谁");

        System.out.println("test:"+test);
    }
}
