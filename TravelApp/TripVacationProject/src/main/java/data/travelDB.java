package data;

import business.plan;
import business.hotel;
import business.activitiesTransportation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class travelDB {
    
    public static void addPlan(plan Plan) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(Plan);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
        public static void addHotel(hotel Hotel) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(Hotel);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
        public static void addActivitiesTransportation(activitiesTransportation ActivitesTransportation) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(ActivitesTransportation);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<plan> selectPlan() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from plan p";
        TypedQuery<plan> q = em.createQuery(qString, plan.class);
        List<plan> plans;
        try {
            plans = q.getResultList();
            if (plans == null || plans.isEmpty()) {
                plans = null;
            }
        } finally {
            em.close();
        }
        
        return plans;
    }

    public static void removePlan(String planName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            plan Plan = em.find(plan.class, planName);
            if (Plan != null) {
                em.remove(Plan);
                trans.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
