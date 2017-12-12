/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Controlador;

import CMR.Controlador.exceptions.NonexistentEntityException;
import CMR.Controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import CMR.Modelo.Client;
import CMR.Modelo.Complaint;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ComplaintJpaController implements Serializable {

    public ComplaintJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Complaint complaint) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client clientID = complaint.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getId());
                complaint.setClientID(clientID);
            }
            em.persist(complaint);
            if (clientID != null) {
                clientID.getComplaintList().add(complaint);
                clientID = em.merge(clientID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComplaint(complaint.getId()) != null) {
                throw new PreexistingEntityException("Complaint " + complaint + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Complaint complaint) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Complaint persistentComplaint = em.find(Complaint.class, complaint.getId());
            Client clientIDOld = persistentComplaint.getClientID();
            Client clientIDNew = complaint.getClientID();
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getId());
                complaint.setClientID(clientIDNew);
            }
            complaint = em.merge(complaint);
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getComplaintList().remove(complaint);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getComplaintList().add(complaint);
                clientIDNew = em.merge(clientIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = complaint.getId();
                if (findComplaint(id) == null) {
                    throw new NonexistentEntityException("The complaint with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Complaint complaint;
            try {
                complaint = em.getReference(Complaint.class, id);
                complaint.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The complaint with id " + id + " no longer exists.", enfe);
            }
            Client clientID = complaint.getClientID();
            if (clientID != null) {
                clientID.getComplaintList().remove(complaint);
                clientID = em.merge(clientID);
            }
            em.remove(complaint);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Complaint> findComplaintEntities() {
        return findComplaintEntities(true, -1, -1);
    }

    public List<Complaint> findComplaintEntities(int maxResults, int firstResult) {
        return findComplaintEntities(false, maxResults, firstResult);
    }

    private List<Complaint> findComplaintEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Complaint.class));
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

    public Complaint findComplaint(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Complaint.class, id);
        } finally {
            em.close();
        }
    }

    public int getComplaintCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Complaint> rt = cq.from(Complaint.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
