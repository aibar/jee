package walkingdevs.jee.fake.service;

import walkingdevs.jee.fake.domain.FakeDict;
import walkingdevs.jee.fake.repository.FakeDictRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FakeDictRepoTestService {
    @Inject
    private FakeDictRepo repo;

    public void shouldFindByName() {
        create("uno");
        create("tre");
        assert repo.byName("uno") != null;
    }

    private FakeDict create(String name) {
        FakeDict dict = new FakeDict();
        dict.setName(name);
        return repo.saveAndFlush(dict);
    }
}