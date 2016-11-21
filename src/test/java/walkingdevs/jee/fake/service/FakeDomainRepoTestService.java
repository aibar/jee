package walkingdevs.jee.fake.service;


import walkingdevs.jee.fake.domain.FakeActor;
import walkingdevs.jee.fake.domain.FakeDomain;
import walkingdevs.jee.fake.repository.FakeActorRepo;
import walkingdevs.jee.fake.repository.FakeDomainRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FakeDomainRepoTestService {
    @Inject
    private FakeDomainRepo domainRepo;

    @Inject
    private FakeActorRepo actorRepo;

    public void shouldFindByCreator() {
        FakeActor creator = createFakeActor();
        FakeDomain expected = createFakeDomain(creator, creator, "", false);
        FakeDomain actual = domainRepo.byCreator(creator).get(0);
        assert expected.equals(actual);
    }

    public void shouldFindByModified() {
        createFakeActor();
        FakeActor modifier = createFakeActor();
        FakeDomain expected = createFakeDomain(modifier, modifier, "", false);
        FakeDomain actual = domainRepo.byModifier(modifier).get(0);
        assert expected.equals(actual);
    }

    public void shouldFindByLocked() {
        createFakeDomain(null, null, "", true);
        createFakeDomain(null, null, "", true);
        createFakeDomain(null, null, "", false);
        assert domainRepo.byLocked(true).size() == 2;
    }

    private FakeDomain createFakeDomain(
        FakeActor creator,
        FakeActor modifier,
        String additionalContent,
        boolean locked
    ) {
        FakeDomain domain = new FakeDomain();
        domain.setCreatedBy(creator);
        domain.setModifiedBy(modifier);
        domain.setAdditionalContent(additionalContent);
        domain.setLocked(locked);
        return domainRepo.saveAndFlush(domain);
    }

    private FakeActor createFakeActor() {
        return actorRepo.saveAndFlush(new FakeActor());
    }
}