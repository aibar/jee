package walkingdevs.jee.fake.service;

import walkingdevs.jee.fake.domain.FakePersistable;
import walkingdevs.jee.fake.repository.FakePersistableRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FakePersistableRepoTestService {
    @Inject
    private FakePersistableRepo repo;

    public void clear() {
        for (FakePersistable fakePersistable : repo.all()) {
            repo.remove(fakePersistable);
        }
    }

    public void shouldPersist() {
        assert create().getId() != null;
    }

    public void shouldFindAll() {
        create();
        create();
        create();
        assert 3 == repo.all().size();
    }

    public void shouldRemove() {
        FakePersistable removing = create();
        assert repo.find(removing.getId()) != null;
        repo.remove(removing);
        assert repo.find(removing.getId()) == null;
    }

    public void shouldCheckNewOrNot() {
        assert repo.isNew(new FakePersistable());
        assert !repo.isNew(create());
    }

    public void shouldFindCreatedAt() {
        FakePersistable uno = create();
        sleep();
        create();
        assert 1 == repo.createdAt(uno.getCreatedDate()).size();
    }

    public void shouldFindModifiedAt() {
        FakePersistable uno = create();
        FakePersistable dos = create();

        uno.setName("uno");
        repo.saveAndFlush(uno);
        sleep();

        dos.setName("dos");
        repo.saveAndFlush(dos);

        assert 1 == repo.modifiedAt(uno.getModifiedDate()).size();
    }

    public void shouldFindModifiedAfter() {
        FakePersistable uno = create();
        FakePersistable dos = create();
        FakePersistable tre = create();

        uno.setName("uno");
        repo.saveAndFlush(uno);
        sleep();

        dos.setName("dos");
        repo.saveAndFlush(dos);
        sleep();

        tre.setName("tre");
        repo.saveAndFlush(tre);

        assert 1 == repo.modifiedAfter(dos.getModifiedDate()).size();
    }

    public void shouldFindModifiedAfterInclusive() {
        FakePersistable uno = create();
        FakePersistable dos = create();
        FakePersistable tre = create();

        uno.setName("uno");
        repo.saveAndFlush(uno);
        sleep();

        dos.setName("dos");
        repo.saveAndFlush(dos);
        sleep();

        tre.setName("tre");
        repo.saveAndFlush(tre);

        assert 2 == repo.modifiedAfterInclusive(dos.getModifiedDate()).size();
    }

    public void shouldFindModifiedBefore() {
        FakePersistable uno = create();
        FakePersistable dos = create();
        FakePersistable tre = create();

        uno.setName("uno");
        repo.saveAndFlush(uno);
        sleep();

        dos.setName("dos");
        repo.saveAndFlush(dos);
        sleep();

        tre.setName("tre");
        repo.saveAndFlush(tre);

        assert 1 == repo.modifiedBefore(dos.getModifiedDate()).size();
    }

    public void shouldFindModifiedBeforeInclusive() {
        FakePersistable uno = create();
        FakePersistable dos = create();
        FakePersistable tre = create();

        uno.setName("uno");
        repo.saveAndFlush(uno);
        sleep();

        dos.setName("dos");
        repo.saveAndFlush(dos);
        sleep();

        tre.setName("tre");
        repo.saveAndFlush(tre);

        assert 2 == repo.modifiedBeforeInclusive(dos.getModifiedDate()).size();
    }

    public void shouldFindCreatedAfter() {
        create();
        sleep();
        FakePersistable dos = create();
        sleep();
        create();

        assert 1 == repo.createdAfter(dos.getCreatedDate()).size();
    }

    public void shouldFindCreatedAfterInclusive() {
        create();
        sleep();
        FakePersistable dos = create();
        sleep();
        create();

        assert 2 == repo.createdAfterInclusive(dos.getCreatedDate()).size();
    }

    public void shouldFindCreatedBefore() {
        create();
        sleep();
        FakePersistable dos = create();
        sleep();
        create();

        assert 1 == repo.createdBefore(dos.getCreatedDate()).size();
    }

    public void shouldFindCreatedBeforeInclusive() {
        create();
        sleep();
        FakePersistable dos = create();
        sleep();
        create();

        assert 2 == repo.createdBeforeInclusive(dos.getCreatedDate()).size();
    }

    public void shouldFindCreatedBetween() {
        FakePersistable uno = create();
        create();
        FakePersistable tre = create();
        sleep();
        create();

        assert 3 == repo.createdBetween(uno.getCreatedDate(), tre.getCreatedDate()).size();
    }

    public void shouldFindModifiedBetween() {
        FakePersistable uno = create();
        FakePersistable dos = create();
        FakePersistable tre = create();

        uno.setName("uno");
        dos.setName("dos");
        repo.saveAndFlush(uno);
        repo.saveAndFlush(dos);
        sleep();

        tre.setName("tre");
        repo.saveAndFlush(tre);

        assert 3 == repo.modifiedBetween(uno.getModifiedDate(), tre.getModifiedDate()).size();
    }

    private FakePersistable create() {
        return repo.saveAndFlush(new FakePersistable());
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException fail) {
            fail.printStackTrace();
        }
    }
}