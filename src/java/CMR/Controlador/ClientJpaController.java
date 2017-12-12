/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMR.Controlador;

import CMR.Controlador.exceptions.NonexistentEntityException;
import CMR.Controlador.exceptions.PreexistingEntityException;
import CMR.Modelo.Client;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import CMR.Modelo.Document;
import java.util.ArrayList;
import java.util.List;
import CMR.Modelo.Complaint;
import CMR.Modelo.Investment;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ClientJpaController implements Serializable {

    public ClientJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Client client) throws PreexistingEntityException, Exception {
        if (client.getDocumentList() == null) {
            client.setDocumentList(new ArrayList<Document>());
        }
        if (client.getComplaintList() == null) {
            client.setComplaintList(new ArrayList<Complaint>());
        }
        if (client.getInvestmentList() == null) {
            client.setInvestmentList(new ArrayList<Investment>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Document> attachedDocumentList = new ArrayList<Document>();
            for (Document documentListDocumentToAttach : client.getDocumentList()) {
                documentListDocumentToAttach = em.getReference(documentListDocumentToAttach.getClass(), documentListDocumentToAttach.getId());
                attachedDocumentList.add(documentListDocumentToAttach);
            }
            client.setDocumentList(attachedDocumentList);
            List<Complaint> attachedComplaintList = new ArrayList<Complaint>();
            for (Complaint complaintListComplaintToAttach : client.getComplaintList()) {
                complaintListComplaintToAttach = em.getReference(complaintListComplaintToAttach.getClass(), complaintListComplaintToAttach.getId());
                attachedComplaintList.add(complaintListComplaintToAttach);
            }
            client.setComplaintList(attachedComplaintList);
            List<Investment> attachedInvestmentList = new ArrayList<Investment>();
            for (Investment investmentListInvestmentToAttach : client.getInvestmentList()) {
                investmentListInvestmentToAttach = em.getReference(investmentListInvestmentToAttach.getClass(), investmentListInvestmentToAttach.getInvID());
                attachedInvestmentList.add(investmentListInvestmentToAttach);
            }
            client.setInvestmentList(attachedInvestmentList);
            em.persist(client);
            for (Document documentListDocument : client.getDocumentList()) {
                Client oldClientIDOfDocumentListDocument = documentListDocument.getClientID();
                documentListDocument.setClientID(client);
                documentListDocument = em.merge(documentListDocument);
                if (oldClientIDOfDocumentListDocument != null) {
                    oldClientIDOfDocumentListDocument.getDocumentList().remove(documentListDocument);
                    oldClientIDOfDocumentListDocument = em.merge(oldClientIDOfDocumentListDocument);
                }
            }
            for (Complaint complaintListComplaint : client.getComplaintList()) {
                Client oldClientIDOfComplaintListComplaint = complaintListComplaint.getClientID();
                complaintListComplaint.setClientID(client);
                complaintListComplaint = em.merge(complaintListComplaint);
                if (oldClientIDOfComplaintListComplaint != null) {
                    oldClientIDOfComplaintListComplaint.getComplaintList().remove(complaintListComplaint);
                    oldClientIDOfComplaintListComplaint = em.merge(oldClientIDOfComplaintListComplaint);
                }
            }
            for (Investment investmentListInvestment : client.getInvestmentList()) {
                Client oldClientIDOfInvestmentListInvestment = investmentListInvestment.getClientID();
                investmentListInvestment.setClientID(client);
                investmentListInvestment = em.merge(investmentListInvestment);
                if (oldClientIDOfInvestmentListInvestment != null) {
                    oldClientIDOfInvestmentListInvestment.getInvestmentList().remove(investmentListInvestment);
                    oldClientIDOfInvestmentListInvestment = em.merge(oldClientIDOfInvestmentListInvestment);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClient(client.getId()) != null) {
                throw new PreexistingEntityException("Client " + client + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Client client) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client persistentClient = em.find(Client.class, client.getId());
            List<Document> documentListOld = persistentClient.getDocumentList();
            List<Document> documentListNew = client.getDocumentList();
            List<Complaint> complaintListOld = persistentClient.getComplaintList();
            List<Complaint> complaintListNew = client.getComplaintList();
            List<Investment> investmentListOld = persistentClient.getInvestmentList();
            List<Investment> investmentListNew = client.getInvestmentList();
            List<Document> attachedDocumentListNew = new ArrayList<Document>();
            for (Document documentListNewDocumentToAttach : documentListNew) {
                documentListNewDocumentToAttach = em.getReference(documentListNewDocumentToAttach.getClass(), documentListNewDocumentToAttach.getId());
                attachedDocumentListNew.add(documentListNewDocumentToAttach);
            }
            documentListNew = attachedDocumentListNew;
            client.setDocumentList(documentListNew);
            List<Complaint> attachedComplaintListNew = new ArrayList<Complaint>();
            for (Complaint complaintListNewComplaintToAttach : complaintListNew) {
                complaintListNewComplaintToAttach = em.getReference(complaintListNewComplaintToAttach.getClass(), complaintListNewComplaintToAttach.getId());
                attachedComplaintListNew.add(complaintListNewComplaintToAttach);
            }
            complaintListNew = attachedComplaintListNew;
            client.setComplaintList(complaintListNew);
            List<Investment> attachedInvestmentListNew = new ArrayList<Investment>();
            for (Investment investmentListNewInvestmentToAttach : investmentListNew) {
                investmentListNewInvestmentToAttach = em.getReference(investmentListNewInvestmentToAttach.getClass(), investmentListNewInvestmentToAttach.getInvID());
                attachedInvestmentListNew.add(investmentListNewInvestmentToAttach);
            }
            investmentListNew = attachedInvestmentListNew;
            client.setInvestmentList(investmentListNew);
            client = em.merge(client);
            for (Document documentListOldDocument : documentListOld) {
                if (!documentListNew.contains(documentListOldDocument)) {
                    documentListOldDocument.setClientID(null);
                    documentListOldDocument = em.merge(documentListOldDocument);
                }
            }
            for (Document documentListNewDocument : documentListNew) {
                if (!documentListOld.contains(documentListNewDocument)) {
                    Client oldClientIDOfDocumentListNewDocument = documentListNewDocument.getClientID();
                    documentListNewDocument.setClientID(client);
                    documentListNewDocument = em.merge(documentListNewDocument);
                    if (oldClientIDOfDocumentListNewDocument != null && !oldClientIDOfDocumentListNewDocument.equals(client)) {
                        oldClientIDOfDocumentListNewDocument.getDocumentList().remove(documentListNewDocument);
                        oldClientIDOfDocumentListNewDocument = em.merge(oldClientIDOfDocumentListNewDocument);
                    }
                }
            }
            for (Complaint complaintListOldComplaint : complaintListOld) {
                if (!complaintListNew.contains(complaintListOldComplaint)) {
                    complaintListOldComplaint.setClientID(null);
                    complaintListOldComplaint = em.merge(complaintListOldComplaint);
                }
            }
            for (Complaint complaintListNewComplaint : complaintListNew) {
                if (!complaintListOld.contains(complaintListNewComplaint)) {
                    Client oldClientIDOfComplaintListNewComplaint = complaintListNewComplaint.getClientID();
                    complaintListNewComplaint.setClientID(client);
                    complaintListNewComplaint = em.merge(complaintListNewComplaint);
                    if (oldClientIDOfComplaintListNewComplaint != null && !oldClientIDOfComplaintListNewComplaint.equals(client)) {
                        oldClientIDOfComplaintListNewComplaint.getComplaintList().remove(complaintListNewComplaint);
                        oldClientIDOfComplaintListNewComplaint = em.merge(oldClientIDOfComplaintListNewComplaint);
                    }
                }
            }
            for (Investment investmentListOldInvestment : investmentListOld) {
                if (!investmentListNew.contains(investmentListOldInvestment)) {
                    investmentListOldInvestment.setClientID(null);
                    investmentListOldInvestment = em.merge(investmentListOldInvestment);
                }
            }
            for (Investment investmentListNewInvestment : investmentListNew) {
                if (!investmentListOld.contains(investmentListNewInvestment)) {
                    Client oldClientIDOfInvestmentListNewInvestment = investmentListNewInvestment.getClientID();
                    investmentListNewInvestment.setClientID(client);
                    investmentListNewInvestment = em.merge(investmentListNewInvestment);
                    if (oldClientIDOfInvestmentListNewInvestment != null && !oldClientIDOfInvestmentListNewInvestment.equals(client)) {
                        oldClientIDOfInvestmentListNewInvestment.getInvestmentList().remove(investmentListNewInvestment);
                        oldClientIDOfInvestmentListNewInvestment = em.merge(oldClientIDOfInvestmentListNewInvestment);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = client.getId();
                if (findClient(id) == null) {
                    throw new NonexistentEntityException("The client with id " + id + " no longer exists.");
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
            Client client;
            try {
                client = em.getReference(Client.class, id);
                client.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client with id " + id + " no longer exists.", enfe);
            }
            List<Document> documentList = client.getDocumentList();
            for (Document documentListDocument : documentList) {
                documentListDocument.setClientID(null);
                documentListDocument = em.merge(documentListDocument);
            }
            List<Complaint> complaintList = client.getComplaintList();
            for (Complaint complaintListComplaint : complaintList) {
                complaintListComplaint.setClientID(null);
                complaintListComplaint = em.merge(complaintListComplaint);
            }
            List<Investment> investmentList = client.getInvestmentList();
            for (Investment investmentListInvestment : investmentList) {
                investmentListInvestment.setClientID(null);
                investmentListInvestment = em.merge(investmentListInvestment);
            }
            em.remove(client);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Client> findClientEntities() {
        return findClientEntities(true, -1, -1);
    }

    public List<Client> findClientEntities(int maxResults, int firstResult) {
        return findClientEntities(false, maxResults, firstResult);
    }

    private List<Client> findClientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Client.class));
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

    public Client findClient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Client> rt = cq.from(Client.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
