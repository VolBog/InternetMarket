package DAO;

import Models.BaseModel;
import Util.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class AbstractDAO<T extends BaseModel> implements DAO<T> {
    Class<T> tClass;


    public AbstractDAO() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        tClass = (Class) pt.getActualTypeArguments()[0];

    }

    public void add(T type) {
        HibernateUtil.getEntityManager().getTransaction().begin();
        try {

            HibernateUtil.getEntityManager().persist(type);
            HibernateUtil.getEntityManager().getTransaction().commit();

        } catch (Exception e) {
            HibernateUtil.getEntityManager().getTransaction().rollback();
        }
    }

    public void update(T type) {
        HibernateUtil.getEntityManager().getTransaction().begin();
        try {

            HibernateUtil.getEntityManager().persist(type);

            HibernateUtil.getEntityManager().merge(type);
            HibernateUtil.getEntityManager().getTransaction().commit();

        } catch (Exception e) {
            HibernateUtil.getEntityManager().getTransaction().rollback();
        }
    }

    public void delete(T type) {
        HibernateUtil.getEntityManager().getTransaction().begin();
        try {

            BaseModel entity = HibernateUtil.getEntityManager().
                    getReference(type.getClass(), type.getId());
            HibernateUtil.getEntityManager().remove(entity);
            HibernateUtil.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            HibernateUtil.getEntityManager().getTransaction().rollback();
        }

    }

    public T getObjectById(Long id) {
        T typeClass = null;
        HibernateUtil.getEntityManager().getTransaction().begin();
        try {

            typeClass = HibernateUtil.getEntityManager().find(tClass, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeClass;

    }

    public List<T> getAll() {
        Entity entity = tClass.getAnnotation(Entity.class);
        String tableName = entity.name();
//        TypedQuery<T> namedQuery = HibernateUtil.getEntityManager().
//                createNamedQuery("from " + tableName, tClass);
//        List<T> resultList = namedQuery.getResultList();
        Query query = HibernateUtil.getEntityManager().createQuery(
                "SELECT c FROM " + tableName + " c", tClass);
        return (List<T>) query.getResultList();

    //    return resultList;
    }
}
