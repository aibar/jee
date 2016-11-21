package walkingdevs.jee.fake.domain;

import walkingdevs.jee.domain.AbstractDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FakeDomain extends AbstractDomain<FakeActor, Long> {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}