package walkingdevs.jee.fake.domain;

import walkingdevs.jee.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FakeActor extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}