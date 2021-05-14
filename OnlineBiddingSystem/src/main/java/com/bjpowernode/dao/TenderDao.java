package com.bjpowernode.dao;

import com.bjpowernode.entity.Tender;
import com.bjpowernode.model.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 */
@Component
public class TenderDao extends HibernateTemplateDao {


    public Object searchTenders(Tender.State state) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Tender.class);

        if (state != null) {
            detachedCriteria.add(Restrictions.eq("state", state));
        }

        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    public Tender searchTender(int tenderId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Tender.class)
                        .add(Restrictions.eq("tenderId", tenderId));

        List<?> byCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        if (byCriteria.isEmpty()) {
            return null;
        }
        return ((Tender) byCriteria.get(0));
    }


    public int insertTender(Tender tender) {
        final Serializable save = hibernateTemplate.save(tender);
        return ((Integer) save);
    }

    public void updateTender(Tender tender) {
        hibernateTemplate.saveOrUpdate(tender);
    }

    public Result delete(int tenderId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Tender.class)
                        .add(Restrictions.eq("tenderId", tenderId));

        hibernateTemplate.deleteAll(hibernateTemplate.findByCriteria(detachedCriteria));
        return new Result(true);
    }
}
