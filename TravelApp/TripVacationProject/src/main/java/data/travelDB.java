package data;

import business.plan;
import business.hotel;
import business.activitiesTransportation;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class travelDB {
    
    public static void addPlan(plan Plan) {
                    if (Plan == null) {
        throw new IllegalArgumentException("Plan cannot be null");
    }
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(Plan);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            System.out.println(e);
        } finally {
            em.close();
        }
    }
        public static void addHotel(hotel Hotel) {
            if (Hotel == null) {
        throw new IllegalArgumentException("Hotel cannot be null");
    }
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(Hotel);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            System.out.println(e);
        } finally {
            em.close();
        }
    }
        public static void addAT(activitiesTransportation ActivitesTransportation) {
            if (ActivitesTransportation == null) {
        throw new IllegalArgumentException("AT cannot be null");
    }
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(ActivitesTransportation);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            System.out.println(e);
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
            if(planName == null || planName.trim().isEmpty()){
                throw new IllegalArgumentException("Plan name cannot be empty");
            }
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
        trans.begin();
        String qString = "SELECT p FROM plan p WHERE p.planName = :planName";
        TypedQuery<plan> q = em.createQuery(qString, plan.class);
        q.setParameter("planName", planName);
        
        List<plan> plans = q.getResultList();
        if (!plans.isEmpty()) {
            plan planToRemove = plans.get(0);
            em.remove(em.merge(planToRemove));
            trans.commit();
        }
    } catch (Exception e) {
        if (trans.isActive()) {
            trans.rollback();
        }
        System.out.println("Error removing plan: " + e);
    } finally {
        em.close();
    }
}
        public static List<hotel> selectHotel() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT h from hotel h";
        TypedQuery<hotel> q = em.createQuery(qString, hotel.class);
        List<hotel> hotels;
        try {
            hotels = q.getResultList();
            if (hotels == null || hotels.isEmpty()) {
                hotels = null;
            }
        } finally {
            em.close();
        }
        
        return hotels;
    }
        public static void removeHotel(String planName, String hotelName) {
            if(planName == null || planName.trim().isEmpty()){
                throw new IllegalArgumentException("Plan name cannot be empty");
            }
            if(hotelName == null || hotelName.trim().isEmpty()){
                throw new IllegalArgumentException("Hotel name cannot be empty");
            }
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
        trans.begin();
        String qString = "SELECT h FROM hotel h WHERE h.planName = :planName AND h.hotelName = :hotelName";
        TypedQuery<hotel> q = em.createQuery(qString, hotel.class);
        q.setParameter("planName", planName);
        q.setParameter("hotelName", hotelName);
        
        List<hotel> hotels = q.getResultList();
        if (!hotels.isEmpty()) {
            hotel hotelToRemove = hotels.get(0);
            em.remove(em.merge(hotelToRemove));
            trans.commit();
        }
    } catch (Exception e) {
        if (trans.isActive()) {
            trans.rollback();
        }
        System.out.println("Error removing hotel: " + e);
    } finally {
        em.close();
    }
}
        
    public static List<activitiesTransportation> selectAT() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a from activitiesTransportation a";
        TypedQuery<activitiesTransportation> q = em.createQuery(qString, activitiesTransportation.class);
        List<activitiesTransportation> ats;
        try {
            ats = q.getResultList();
            if (ats == null || ats.isEmpty()) {
                ats = null;
            }
        } finally {
            em.close();
        }
        
        return ats;
    }
    public static void removeAT(String planName) {
            if(planName == null || planName.trim().isEmpty()){
                throw new IllegalArgumentException("Plan name cannot be empty");
            }
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
        trans.begin();
        String qString = "SELECT p FROM ActivitiesTransportation p WHERE p.planName = :planName";
        TypedQuery<activitiesTransportation> q = em.createQuery(qString, activitiesTransportation.class);
        q.setParameter("planName", planName);
        
        List<activitiesTransportation> ActivitiesTransportation = q.getResultList();
        if (!ActivitiesTransportation.isEmpty()) {
            activitiesTransportation ATToRemove = ActivitiesTransportation.get(0);
            em.remove(em.merge(ATToRemove));
            trans.commit();
        }
    } catch (Exception e) {
        if (trans.isActive()) {
            trans.rollback();
        }
        System.out.println("Error removing hotel: " + e);
    } finally {
        em.close();
    }
}
}
