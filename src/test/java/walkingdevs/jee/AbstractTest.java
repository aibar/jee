package walkingdevs.jee;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class AbstractTest extends Assert {
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
            .addPackages(true, "walkingdevs.jee")
            .addAsResource("persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("resources.xml");
    }
}