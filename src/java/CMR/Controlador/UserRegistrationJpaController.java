/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Controlador;

import CMR.Controlador.exceptions.NonexistentEntityException;
import CMR.Controlador.exceptions.PreexistingEntityException;
import CMR.Modelo.UserRegistration;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
public class UserRegistrationJpaController implements Serializable {

    public UserRegistrationJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserRegistration userRegistration) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userRegistration);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUserRegistration(userRegistration.getId()) != null) {
                throw new PreexistingEntityException("UserRegistration " + userRegistration + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserRegistration userRegistration) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userRegistration = em.merge(userRegistration);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = userRegistration.getId();
                if (findUserRegistration(id) == null) {
                    throw new NonexistentEntityException("The userRegistration with id " + id + " no longer exists.");
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
            UserRegistration userRegistration;
            try {
                userRegistration = em.getReference(UserRegistration.class, id);
                userRegistration.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userRegistration with id " + id + " no longer exists.", enfe);
            }
            em.remove(userRegistration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserRegistration> findUserRegistrationEntities() {
        return findUserRegistrationEntities(true, -1, -1);
    }

    public List<UserRegistration> findUserRegistrationEntities(int maxResults, int firstResult) {
        return findUserRegistrationEntities(false, maxResults, firstResult);
    }

    private List<UserRegistration> findUserRegistrationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserRegistration.class));
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

    public UserRegistration findUserRegistration(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserRegistration.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserRegistrationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserRegistration> rt = cq.from(UserRegistration.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
