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
import CMR.Modelo.Investment;
import CMR.Modelo.Sales;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class SalesJpaController implements Serializable {

    public SalesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sales sales) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Investment investmentID = sales.getInvestmentID();
            if (investmentID != null) {
                investmentID = em.getReference(investmentID.getClass(), investmentID.getInvID());
                sales.setInvestmentID(investmentID);
            }
            em.persist(sales);
            if (investmentID != null) {
                investmentID.getSalesList().add(sales);
                investmentID = em.merge(investmentID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSales(sales.getSId()) != null) {
                throw new PreexistingEntityException("Sales " + sales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sales sales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sales persistentSales = em.find(Sales.class, sales.getSId());
            Investment investmentIDOld = persistentSales.getInvestmentID();
            Investment investmentIDNew = sales.getInvestmentID();
            if (investmentIDNew != null) {
                investmentIDNew = em.getReference(investmentIDNew.getClass(), investmentIDNew.getInvID());
                sales.setInvestmentID(investmentIDNew);
            }
            sales = em.merge(sales);
            if (investmentIDOld != null && !investmentIDOld.equals(investmentIDNew)) {
                investmentIDOld.getSalesList().remove(sales);
                investmentIDOld = em.merge(investmentIDOld);
            }
            if (investmentIDNew != null && !investmentIDNew.equals(investmentIDOld)) {
                investmentIDNew.getSalesList().add(sales);
                investmentIDNew = em.merge(investmentIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sales.getSId();
                if (findSales(id) == null) {
                    throw new NonexistentEntityException("The sales with id " + id + " no longer exists.");
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
            Sales sales;
            try {
                sales = em.getReference(Sales.class, id);
                sales.getSId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sales with id " + id + " no longer exists.", enfe);
            }
            Investment investmentID = sales.getInvestmentID();
            if (investmentID != null) {
                investmentID.getSalesList().remove(sales);
                investmentID = em.merge(investmentID);
            }
            em.remove(sales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sales> findSalesEntities() {
        return findSalesEntities(true, -1, -1);
    }

    public List<Sales> findSalesEntities(int maxResults, int firstResult) {
        return findSalesEntities(false, maxResults, firstResult);
    }

    private List<Sales> findSalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sales.class));
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

    public Sales findSales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sales.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sales> rt = cq.from(Sales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
