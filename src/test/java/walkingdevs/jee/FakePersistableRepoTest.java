package walkingdevs.jee;

import walkingdevs.jee.fake.service.FakePersistableRepoTestService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class FakePersistableRepoTest extends AbstractTest {
    @After
    public void clear() {
        test.clear();
    }

    @Inject
    FakePersistableRepoTestService test;

    @Test
    public void shouldPersist() {
        test.shouldPersist();
    }

    @Test
    public void shouldFindAll() {
        test.shouldFindAll();
    }

    @Test
    public void shouldRemove() {
        test.shouldRemove();
    }

    @Test
    public void shouldCheckNewOrNot() {
        test.shouldCheckNewOrNot();
    }

    @Test
    public void shouldFindCreatedAt() {
        test.shouldFindCreatedAt();
    }

    @Test
    public void shouldFindModifiedAt() {
        test.shouldFindModifiedAt();
    }

    @Test
    public void shouldFindModifiedAfter() {
        test.shouldFindModifiedAfter();
    }

    @Test
    public void shouldFindModifiedAfterInclusive() {
        test.shouldFindModifiedAfterInclusive();
    }

    @Test
    public void shouldFindModifiedBefore() {
        test.shouldFindModifiedBefore();
    }

    @Test
    public void shouldFindModifiedBeforeInclusive() {
        test.shouldFindModifiedBeforeInclusive();
    }

    @Test
    public void shouldFindCreatedAfter() {
        test.shouldFindCreatedAfter();
    }

    @Test
    public void shouldFindCreatedAfterInclusive() {
        test.shouldFindCreatedAfterInclusive();
    }

    @Test
    public void shouldFindCreatedBefore() {
        test.shouldFindCreatedBefore();
    }

    @Test
    public void shouldFindCreatedBeforeInclusive() {
        test.shouldFindCreatedBeforeInclusive();
    }

    @Test
    public void shouldFindCreatedBetween() {
        test.shouldFindCreatedBetween();
    }

    @Test
    public void shouldFindModifiedBetween() {
        test.shouldFindModifiedBetween();
    }
}