package walkingdevs.jee.fake.repository;

import walkingdevs.jee.fake.domain.FakeActor;
import walkingdevs.jee.fake.domain.FakeDomain;
import walkingdevs.jee.repository.DomainRepo;

import javax.ejb.Stateless;

@Stateless
public class FakeDomainRepo extends DomainRepo<FakeDomain, FakeActor, Long> {
}