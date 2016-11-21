package walkingdevs.jee.fake.domain;

import walkingdevs.jee.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FakePersistable extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}