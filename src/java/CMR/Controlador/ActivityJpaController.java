/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Controlador;

import CMR.Controlador.exceptions.NonexistentEntityException;
import CMR.Controlador.exceptions.PreexistingEntityException;
import CMR.Modelo.Activity;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import CMR.Modelo.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ActivityJpaController implements Serializable {

    public ActivityJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Activity activity) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee staffID = activity.getStaffID();
            if (staffID != null) {
                staffID = em.getReference(staffID.getClass(), staffID.getStaffID());
                activity.setStaffID(staffID);
            }
            em.persist(activity);
            if (staffID != null) {
                staffID.getActivityList().add(activity);
                staffID = em.merge(staffID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findActivity(activity.getId()) != null) {
                throw new PreexistingEntityException("Activity " + activity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Activity activity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Activity persistentActivity = em.find(Activity.class, activity.getId());
            Employee staffIDOld = persistentActivity.getStaffID();
            Employee staffIDNew = activity.getStaffID();
            if (staffIDNew != null) {
                staffIDNew = em.getReference(staffIDNew.getClass(), staffIDNew.getStaffID());
                activity.setStaffID(staffIDNew);
            }
            activity = em.merge(activity);
            if (staffIDOld != null && !staffIDOld.equals(staffIDNew)) {
                staffIDOld.getActivityList().remove(activity);
                staffIDOld = em.merge(staffIDOld);
            }
            if (staffIDNew != null && !staffIDNew.equals(staffIDOld)) {
                staffIDNew.getActivityList().add(activity);
                staffIDNew = em.merge(staffIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = activity.getId();
                if (findActivity(id) == null) {
                    throw new NonexistentEntityException("The activity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Activity activity;
            try {
                activity = em.getReference(Activity.class, id);
                activity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The activity with id " + id + " no longer exists.", enfe);
            }
            Employee staffID = activity.getStaffID();
            if (staffID != null) {
                staffID.getActivityList().remove(activity);
                staffID = em.merge(staffID);
            }
            em.remove(activity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Activity> findActivityEntities() {
        return findActivityEntities(true, -1, -1);
    }

    public List<Activity> findActivityEntities(int maxResults, int firstResult) {
        return findActivityEntities(false, maxResults, firstResult);
    }

    private List<Activity> findActivityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Activity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Activity findActivity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Activity.class, id);
        } finally {
            em.close();
        }
    }

    public int getActivityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Activity> rt = cq.from(Activity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
