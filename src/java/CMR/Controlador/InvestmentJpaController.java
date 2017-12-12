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
import CMR.Modelo.Investment;
import CMR.Modelo.Sales;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class InvestmentJpaController implements Serializable {

    public InvestmentJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Investment investment) throws PreexistingEntityException, Exception {
        if (investment.getSalesList() == null) {
            investment.setSalesList(new ArrayList<Sales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client clientID = investment.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getId());
                investment.setClientID(clientID);
            }
            List<Sales> attachedSalesList = new ArrayList<Sales>();
            for (Sales salesListSalesToAttach : investment.getSalesList()) {
                salesListSalesToAttach = em.getReference(salesListSalesToAttach.getClass(), salesListSalesToAttach.getSId());
                attachedSalesList.add(salesListSalesToAttach);
            }
            investment.setSalesList(attachedSalesList);
            em.persist(investment);
            if (clientID != null) {
                clientID.getInvestmentList().add(investment);
                clientID = em.merge(clientID);
            }
            for (Sales salesListSales : investment.getSalesList()) {
                Investment oldInvestmentIDOfSalesListSales = salesListSales.getInvestmentID();
                salesListSales.setInvestmentID(investment);
                salesListSales = em.merge(salesListSales);
                if (oldInvestmentIDOfSalesListSales != null) {
                    oldInvestmentIDOfSalesListSales.getSalesList().remove(salesListSales);
                    oldInvestmentIDOfSalesListSales = em.merge(oldInvestmentIDOfSalesListSales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvestment(investment.getInvID()) != null) {
                throw new PreexistingEntityException("Investment " + investment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Investment investment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Investment persistentInvestment = em.find(Investment.class, investment.getInvID());
            Client clientIDOld = persistentInvestment.getClientID();
            Client clientIDNew = investment.getClientID();
            List<Sales> salesListOld = persistentInvestment.getSalesList();
            List<Sales> salesListNew = investment.getSalesList();
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getId());
                investment.setClientID(clientIDNew);
            }
            List<Sales> attachedSalesListNew = new ArrayList<Sales>();
            for (Sales salesListNewSalesToAttach : salesListNew) {
                salesListNewSalesToAttach = em.getReference(salesListNewSalesToAttach.getClass(), salesListNewSalesToAttach.getSId());
                attachedSalesListNew.add(salesListNewSalesToAttach);
            }
            salesListNew = attachedSalesListNew;
            investment.setSalesList(salesListNew);
            investment = em.merge(investment);
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getInvestmentList().remove(investment);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getInvestmentList().add(investment);
                clientIDNew = em.merge(clientIDNew);
            }
            for (Sales salesListOldSales : salesListOld) {
                if (!salesListNew.contains(salesListOldSales)) {
                    salesListOldSales.setInvestmentID(null);
                    salesListOldSales = em.merge(salesListOldSales);
                }
            }
            for (Sales salesListNewSales : salesListNew) {
                if (!salesListOld.contains(salesListNewSales)) {
                    Investment oldInvestmentIDOfSalesListNewSales = salesListNewSales.getInvestmentID();
                    salesListNewSales.setInvestmentID(investment);
                    salesListNewSales = em.merge(salesListNewSales);
                    if (oldInvestmentIDOfSalesListNewSales != null && !oldInvestmentIDOfSalesListNewSales.equals(investment)) {
                        oldInvestmentIDOfSalesListNewSales.getSalesList().remove(salesListNewSales);
                        oldInvestmentIDOfSalesListNewSales = em.merge(oldInvestmentIDOfSalesListNewSales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = investment.getInvID();
                if (findInvestment(id) == null) {
                    throw new NonexistentEntityException("The investment with id " + id + " no longer exists.");
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
            Investment investment;
            try {
                investment = em.getReference(Investment.class, id);
                investment.getInvID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The investment with id " + id + " no longer exists.", enfe);
            }
            Client clientID = investment.getClientID();
            if (clientID != null) {
                clientID.getInvestmentList().remove(investment);
                clientID = em.merge(clientID);
            }
            List<Sales> salesList = investment.getSalesList();
            for (Sales salesListSales : salesList) {
                salesListSales.setInvestmentID(null);
                salesListSales = em.merge(salesListSales);
            }
            em.remove(investment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Investment> findInvestmentEntities() {
        return findInvestmentEntities(true, -1, -1);
    }

    public List<Investment> findInvestmentEntities(int maxResults, int firstResult) {
        return findInvestmentEntities(false, maxResults, firstResult);
    }

    private List<Investment> findInvestmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Investment.class));
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

    public Investment findInvestment(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Investment.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvestmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Investment> rt = cq.from(Investment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
