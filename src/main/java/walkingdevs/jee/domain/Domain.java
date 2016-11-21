package walkingdevs.jee.domain;

public interface Domain<Actor extends Persistable, I> extends Persistable<I> {
    Actor getCreatedBy();

    Actor getModifiedBy();

    boolean isLocked();

    String getAdditionalContent();
}