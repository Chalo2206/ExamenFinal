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
import CMR.Modelo.Document;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class DocumentJpaController implements Serializable {

    public DocumentJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Document document) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client clientID = document.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getId());
                document.setClientID(clientID);
            }
            em.persist(document);
            if (clientID != null) {
                clientID.getDocumentList().add(document);
                clientID = em.merge(clientID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocument(document.getId()) != null) {
                throw new PreexistingEntityException("Document " + document + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Document document) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Document persistentDocument = em.find(Document.class, document.getId());
            Client clientIDOld = persistentDocument.getClientID();
            Client clientIDNew = document.getClientID();
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getId());
                document.setClientID(clientIDNew);
            }
            document = em.merge(document);
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getDocumentList().remove(document);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getDocumentList().add(document);
                clientIDNew = em.merge(clientIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = document.getId();
                if (findDocument(id) == null) {
                    throw new NonexistentEntityException("The document with id " + id + " no longer exists.");
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
            Document document;
            try {
                document = em.getReference(Document.class, id);
                document.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The document with id " + id + " no longer exists.", enfe);
            }
            Client clientID = document.getClientID();
            if (clientID != null) {
                clientID.getDocumentList().remove(document);
                clientID = em.merge(clientID);
            }
            em.remove(document);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Document> findDocumentEntities() {
        return findDocumentEntities(true, -1, -1);
    }

    public List<Document> findDocumentEntities(int maxResults, int firstResult) {
        return findDocumentEntities(false, maxResults, firstResult);
    }

    private List<Document> findDocumentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Document.class));
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

    public Document findDocument(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Document.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Document> rt = cq.from(Document.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
