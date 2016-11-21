package walkingdevs.jee.fake.domain;

import walkingdevs.jee.domain.AbstractDict;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FakeDict extends AbstractDict<FakeActor, Long> {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}