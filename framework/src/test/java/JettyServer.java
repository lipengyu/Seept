import org.eclipse.jetty.server.Server;
import org.seept.framework.test.jetty.JettyFactory;
import org.seept.framework.test.springtest.ProfilesInfo;

/**
 * @author : lihaoquan
 *
 */
public class JettyServer {

    public static final int PORT = 7001;
    public static final String CONTEXT = "/seept";
    public static final String[] TLD_JAR_NAMES
            = new String[] { "sitemesh", "spring-webmvc", "shiro-web"};

    public static void main(String[] args) throws Exception{

        ProfilesInfo.setProfileAsSystemProperty(ProfilesInfo.DEVELOPMENT);

        Server server = JettyFactory.openServer(PORT, CONTEXT);
        JettyFactory.setTldJarNames(server,TLD_JAR_NAMES);

        try {
            server.start();
            System.out.println("[INFO] Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("[HINT] Hit Enter to reload the application quickly");

            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
