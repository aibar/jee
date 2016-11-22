package walkingdevs.jee.repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface Repo<E, I> {
    List<E> all();

    E find(I i);

    Repo<E, I> remove(E e);
    Repo<E, I> removeAndFlush(E e);

    E save(E e);
    E saveAndFlush(E e);

    Repo<E, I> flush();

    boolean isNew(E e);

    CriteriaQuery<E> criteriaQuery();

    TypedQuery<E> typedQuery(String query);

    Class<E> type();

    List<E> byColumn(String column, Object val);
}