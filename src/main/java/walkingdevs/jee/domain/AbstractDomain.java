package walkingdevs.jee.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractDomain<Actor extends Persistable, I> extends AbstractPersistable<I> implements Domain<Actor, I> {
    @ManyToOne
    @JoinColumn(updatable = false)
    private Actor createdBy;

    @ManyToOne
    private Actor modifiedBy;

    private boolean locked = false;

    private String additionalContent;

    public Actor getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Actor createdBy) {
        this.createdBy = createdBy;
    }

    public Actor getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Actor modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getAdditionalContent() {
        return additionalContent;
    }

    public void setAdditionalContent(String additionalContent) {
        this.additionalContent = additionalContent;
    }
}