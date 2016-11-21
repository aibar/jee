package walkingdevs.jee.fake.repository;

import walkingdevs.jee.fake.domain.FakePersistable;
import walkingdevs.jee.repository.PersistableRepo;

import javax.ejb.Stateless;

@Stateless
public class FakePersistableRepo extends PersistableRepo<FakePersistable, Long> {
}