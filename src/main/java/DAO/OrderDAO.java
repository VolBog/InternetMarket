package DAO;

import Models.Order;
import Util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class OrderDAO extends AbstractDAO<Order>{

    public List<Order> findByPhone(int phone){
        TypedQuery<Order> namedQuery = HibernateUtil.getEntityManager().
                createNamedQuery("SELECT c FROM Orders WHERE c.client.phone = :number", Order.class);
        namedQuery.setParameter("number", phone);
        List<Order> resultList = namedQuery.getResultList();

        return resultList;
    }

    public List<Order> findByDateRange(Date first, Date second){
        TypedQuery<Order> namedQuery = HibernateUtil.getEntityManager().
                createNamedQuery("SELECT c FROM Orders WHERE (c.date BETWEEN :first AND :second)", Order.class);
        namedQuery.setParameter("first", first);
        namedQuery.setParameter("second", second);
        List<Order> resultList = namedQuery.getResultList();

        return resultList;
    }
}
