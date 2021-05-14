package com.bjpowernode.dao;

import com.bjpowernode.entity.Bid;
import com.bjpowernode.entity.Users;
import com.bjpowernode.model.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 */
@Component
public class BidDao extends HibernateTemplateDao {


    public Object searchBids(Bid.State state) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Bid.class);

        if (state != null) {
            detachedCriteria.add(Restrictions.eq("state", state));
        }

        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public Object searchBids(Users users, Bid.State state) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Bid.class)
                        .add(Restrictions.eq("users.userId", users.getUserId()));

        if (state != null) {
            detachedCriteria.add(Restrictions.eq("state", state));
        }

        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public Bid searchBid(int bidId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Bid.class)
                        .add(Restrictions.eq("bidId", bidId));

        List<?> byCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        if (byCriteria.isEmpty()) {
            return null;
        }
        return ((Bid) byCriteria.get(0));
    }


    public int insertBid(Bid bid) {
        final Serializable save = hibernateTemplate.save(bid);
        return ((Integer) save);
    }

    public void updateBid(Bid bid) {
        hibernateTemplate.saveOrUpdate(bid);
    }

    public Result delete(int bidId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Bid.class)
                        .add(Restrictions.eq("bidId", bidId));

        hibernateTemplate.deleteAll(hibernateTemplate.findByCriteria(detachedCriteria));
        return new Result(true);
    }


}
