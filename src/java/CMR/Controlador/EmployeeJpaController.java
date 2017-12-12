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
import CMR.Modelo.Activity;
import CMR.Modelo.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class EmployeeJpaController implements Serializable {

    public EmployeeJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CRMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Employee employee) throws PreexistingEntityException, Exception {
        if (employee.getActivityList() == null) {
            employee.setActivityList(new ArrayList<Activity>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Activity> attachedActivityList = new ArrayList<Activity>();
            for (Activity activityListActivityToAttach : employee.getActivityList()) {
                activityListActivityToAttach = em.getReference(activityListActivityToAttach.getClass(), activityListActivityToAttach.getId());
                attachedActivityList.add(activityListActivityToAttach);
            }
            employee.setActivityList(attachedActivityList);
            em.persist(employee);
            for (Activity activityListActivity : employee.getActivityList()) {
                Employee oldStaffIDOfActivityListActivity = activityListActivity.getStaffID();
                activityListActivity.setStaffID(employee);
                activityListActivity = em.merge(activityListActivity);
                if (oldStaffIDOfActivityListActivity != null) {
                    oldStaffIDOfActivityListActivity.getActivityList().remove(activityListActivity);
                    oldStaffIDOfActivityListActivity = em.merge(oldStaffIDOfActivityListActivity);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmployee(employee.getStaffID()) != null) {
                throw new PreexistingEntityException("Employee " + employee + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Employee employee) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee persistentEmployee = em.find(Employee.class, employee.getStaffID());
            List<Activity> activityListOld = persistentEmployee.getActivityList();
            List<Activity> activityListNew = employee.getActivityList();
            List<Activity> attachedActivityListNew = new ArrayList<Activity>();
            for (Activity activityListNewActivityToAttach : activityListNew) {
                activityListNewActivityToAttach = em.getReference(activityListNewActivityToAttach.getClass(), activityListNewActivityToAttach.getId());
                attachedActivityListNew.add(activityListNewActivityToAttach);
            }
            activityListNew = attachedActivityListNew;
            employee.setActivityList(activityListNew);
            employee = em.merge(employee);
            for (Activity activityListOldActivity : activityListOld) {
                if (!activityListNew.contains(activityListOldActivity)) {
                    activityListOldActivity.setStaffID(null);
                    activityListOldActivity = em.merge(activityListOldActivity);
                }
            }
            for (Activity activityListNewActivity : activityListNew) {
                if (!activityListOld.contains(activityListNewActivity)) {
                    Employee oldStaffIDOfActivityListNewActivity = activityListNewActivity.getStaffID();
                    activityListNewActivity.setStaffID(employee);
                    activityListNewActivity = em.merge(activityListNewActivity);
                    if (oldStaffIDOfActivityListNewActivity != null && !oldStaffIDOfActivityListNewActivity.equals(employee)) {
                        oldStaffIDOfActivityListNewActivity.getActivityList().remove(activityListNewActivity);
                        oldStaffIDOfActivityListNewActivity = em.merge(oldStaffIDOfActivityListNewActivity);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = employee.getStaffID();
                if (findEmployee(id) == null) {
                    throw new NonexistentEntityException("The employee with id " + id + " no longer exists.");
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
            Employee employee;
            try {
                employee = em.getReference(Employee.class, id);
                employee.getStaffID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employee with id " + id + " no longer exists.", enfe);
            }
            List<Activity> activityList = employee.getActivityList();
            for (Activity activityListActivity : activityList) {
                activityListActivity.setStaffID(null);
                activityListActivity = em.merge(activityListActivity);
            }
            em.remove(employee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Employee> findEmployeeEntities() {
        return findEmployeeEntities(true, -1, -1);
    }

    public List<Employee> findEmployeeEntities(int maxResults, int firstResult) {
        return findEmployeeEntities(false, maxResults, firstResult);
    }

    private List<Employee> findEmployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employee.class));
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

    public Employee findEmployee(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employee> rt = cq.from(Employee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
