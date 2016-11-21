package walkingdevs.jee;

import walkingdevs.jee.fake.service.FakeDomainRepoTestService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class FakeDomainRepoTest extends AbstractTest {
    @Inject
    FakeDomainRepoTestService test;

    @Test
    public void shouldFindByCreator() {
        test.shouldFindByCreator();
    }

    @Test
    public void shouldFindByLocked() {
        test.shouldFindByLocked();
    }

    @Test
    public void shouldFindByModified() {
        test.shouldFindByModified();
    }
}