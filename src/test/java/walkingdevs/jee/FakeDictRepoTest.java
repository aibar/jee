package walkingdevs.jee;

import walkingdevs.jee.fake.service.FakeDictRepoTestService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class FakeDictRepoTest extends AbstractTest {
    @Inject
    FakeDictRepoTestService test;

    @Test
    public void shouldFindByName() {
        test.shouldFindByName();
    }
}