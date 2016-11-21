package walkingdevs.jee.fake.repository;

import walkingdevs.jee.fake.domain.FakeActor;
import walkingdevs.jee.fake.domain.FakeDict;
import walkingdevs.jee.repository.DictRepo;

import javax.ejb.Stateless;

@Stateless
public class FakeDictRepo extends DictRepo<FakeDict, FakeActor, Long> {
}