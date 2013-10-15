package com.seept.framework.test.jetty;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.List;

/**
 * @author : lihaoquan
 *
 * Jetty服务工厂
 */
public class JettyFactory {

    private static final String DEFAULT_WEBAPP_PATH = "framework/src/main/webapp";
    private static final String WINDOWS_WEBDEFAULT_PATH
            = "framework/src/test/resources/jetty/webdefault-windows.xml";

    /**
     * 启动Jetty服务
     * @param port
     * @param contextPath
     * @return
     */
    public static Server openServer(int port,String contextPath) {
        Server server = new Server();
        server.setStopAtShutdown(true);

        SelectChannelConnector selectChannelConnector = new SelectChannelConnector();
        selectChannelConnector.setPort(port);
        selectChannelConnector.setReuseAddress(false);
        server.setConnectors(new Connector[]{selectChannelConnector});

        WebAppContext webAppContext = new WebAppContext(DEFAULT_WEBAPP_PATH,contextPath);
        webAppContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
        server.setHandler(webAppContext);

        return server;
    }

    /**
     * 设置除jstl-*.jar外其他含tld文件的jar包的名称.
     * jar名称不需要版本号，如sitemesh, shiro-web
     */
    public static void setTldJarNames(Server server, String... jarNames) {
        WebAppContext context = (WebAppContext) server.getHandler();
        List<String> jarNameExprssions = Lists.newArrayList(".*/jstl-[^/]*\\.jar$", ".*/.*taglibs[^/]*\\.jar$");
        for (String jarName : jarNames) {
            jarNameExprssions.add(".*/" + jarName + "-[^/]*\\.jar$");
        }

        context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                StringUtils.join(jarNameExprssions, '|'));

    }

    /**
     * 快速重新启动application，重载target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        classLoader.addClassPath("target/classes");
        classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }
}
