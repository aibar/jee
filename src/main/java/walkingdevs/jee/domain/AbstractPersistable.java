package walkingdevs.jee.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractPersistable<I> implements Persistable<I> {
    @Version
    private int version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate = new Date();

    @PrePersist @PreUpdate
    private void modified() {
        modifiedDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        return getId() != null
            && o != null
            && o instanceof Persistable
            && getId().equals(((Persistable) o).getId());
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}