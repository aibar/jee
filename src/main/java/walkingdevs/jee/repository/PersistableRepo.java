package walkingdevs.jee.repository;

import walkingdevs.jee.domain.Persistable;
import walkingdevs.val.Val;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistableRepo<P extends Persistable<I>, I> extends AbstractRepo<P, I> {
    public boolean isNew(P p) {
        return find(
            Val.NULL("p", p).get().getId()
        ) == null;
    }


    public List<P> createdBetween(Date from, Date to) {
        Val.NULL("from", from).crash();
        Val.NULL("to", to).crash();
        try {
            return typedQuery("select e from " + type().getSimpleName() + " e where e.createdDate between :from and :to")
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
        } catch (NoResultException fail) {
            return new ArrayList<>();
        }
    }

    public List<P> modifiedBetween(Date from, Date to) {
        Val.NULL("from", from).crash();
        Val.NULL("to", to).crash();
        try {
            return typedQuery("select e from " + type().getSimpleName() + " e where e.modifiedDate between :from and :to")
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
        } catch (NoResultException fail) {
            return new ArrayList<>();
        }
    }

    public List<P> createdAt(Date date) {
        return byColumn("createdDate", date);
    }

    public List<P> modifiedAt(Date date) {
        return byColumn("modifiedDate", date);
    }

    public List<P> modifiedAfter(Date date) {
        return byDates(date, "e.modifiedDate > :date");
    }

    public List<P> modifiedAfterInclusive(Date date) {
        return byDates(date, "e.modifiedDate >= :date");
    }

    public List<P> modifiedBefore(Date date) {
        return byDates(date, "e.modifiedDate < :date");
    }

    public List<P> modifiedBeforeInclusive(Date date) {
        return byDates(date, "e.modifiedDate <= :date");
    }

    public List<P> createdAfter(Date date) {
        return byDates(date, "e.createdDate > :date");
    }

    public List<P> createdAfterInclusive(Date date) {
        return byDates(date, "e.createdDate >= :date");
    }

    public List<P> createdBefore(Date date) {
        return byDates(date, "e.createdDate < :date");
    }

    public List<P> createdBeforeInclusive(Date date) {
        return byDates(date, "e.createdDate <= :date");
    }

    private List<P> byDates(Date date, String condition) {
        Val.NULL("date", date).crash();
        Val.NULL("condition", condition).crash();
        try {
            return typedQuery("select e from " + type().getSimpleName() + " e where " + condition)
                .setParameter("date", date)
                .getResultList();
        } catch (NoResultException fail) {
            return new ArrayList<>();
        }
    }
}