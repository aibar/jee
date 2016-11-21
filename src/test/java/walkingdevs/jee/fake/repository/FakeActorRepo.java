package walkingdevs.jee.fake.repository;

import walkingdevs.jee.fake.domain.FakeActor;
import walkingdevs.jee.repository.PersistableRepo;

import javax.ejb.Stateless;

@Stateless
public class FakeActorRepo extends PersistableRepo<FakeActor, Long> {
}