package walkingdevs.jee.repository;

import walkingdevs.jee.domain.Domain;
import walkingdevs.jee.domain.Persistable;

import java.util.List;

public class DictRepo<D extends Domain<Actor, I>, Actor extends Persistable, I> extends DomainRepo<D, Actor, I> {
    public List<D> byName(String name) {
        return byColumn("name", name);
    }
}