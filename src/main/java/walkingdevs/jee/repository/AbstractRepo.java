package walkingdevs.jee.repository;

import walkingdevs.val.Val;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepo<E, I> implements Repo<E, I> {
    public List<E> all() {
        CriteriaQuery<E> criteriaQuery = criteriaQuery();
        return em.createQuery(
            criteriaQuery.select(
                criteriaQuery.from(type)
            )
        ).getResultList();
    }

    public E find(I i) {
        return em.find(type, i);
    }

    public Repo<E, I> remove(E e) {
        em.remove(Val.isNull(e, "e").get());
        return this;
    }

    public Repo<E, I> removeAndFlush(E e) {
        remove(e);
        flush();
        return this;
    }

    public E save(E e) {
        if (isNew(e)) {
            em.persist(e);
            return e;
        } else {
            return em.merge(e);
        }
    }

    public E saveAndFlush(E e) {
        e = save(e);
        flush();
        return e;
    }

    public Repo<E, I> flush() {
        em.flush();
        return this;
    }

    public CriteriaQuery<E> criteriaQuery() {
        return em.getCriteriaBuilder().createQuery(type);
    }

    public TypedQuery<E> typedQuery(String query) {
        return em.createQuery(
            Val.isNull(query, "query").get(),
            type
        );
    }

    public Class<E> type() {
        return type;
    }

    public List<E> byColumn(String column, Object val) {
        Val.isNull(column, "column").fail();
        try {
            return typedQuery("select e from " + type().getSimpleName() + " e where e." + column + " = :val")
                .setParameter("val", val)
                .getResultList();
        } catch (NoResultException fail) {
            return new ArrayList<>();
        }
    }

    public AbstractRepo() {
        // It's Ok.
        type = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private final Class<E> type;

    @PersistenceContext
    private EntityManager em;
}