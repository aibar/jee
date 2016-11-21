package walkingdevs.jee.repository;

import walkingdevs.jee.domain.Domain;
import walkingdevs.jee.domain.Persistable;

import java.util.List;

public class DomainRepo<D extends Domain<Actor, I>, Actor extends Persistable, I> extends PersistableRepo<D, I> {
    public List<D> byCreator(Actor actor) {
        return byColumn("createdBy", actor);
    }

    public List<D> byModifier(Actor actor) {
        return byColumn("modifiedBy", actor);
    }

    public List<D> byLocked(boolean locked) {
        return byColumn("locked", locked);
    }
}