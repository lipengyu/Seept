package org.seept.framework.modules.webservice.jaxrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author: Quan
 * @Description: http://127.0.0.1:7001/seept/cxf/jaxrs/user/12345678
 */
@Path("/user")
public class UserJaxRsService {

    private static Logger logger = LoggerFactory.getLogger(UserJaxRsService.class);

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAsXML(@PathParam("id") String id) {
        String test = "here is testing:"+id;
        logger.info(test);
        return test;
    }
}
