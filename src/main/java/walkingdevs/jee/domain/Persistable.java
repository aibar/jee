package walkingdevs.jee.domain;

import java.util.Date;

public interface Persistable<I> {
    I getId();

    Date getCreatedDate();

    Date getModifiedDate();
}