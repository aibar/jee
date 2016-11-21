package walkingdevs.jee.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractDict<Actor extends Persistable, I> extends AbstractDomain<Actor, I> implements Dict<Actor, I> {
    @NotNull
    @Size(min = 1)
    @Column(unique = true)
    private String name;

    private String description;

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
}