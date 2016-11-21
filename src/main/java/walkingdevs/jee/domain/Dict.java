package walkingdevs.jee.domain;

public interface Dict<Actor extends Persistable, I> extends Domain<Actor, I> {
    String getName();

    String getDescription();
}