/**
 * 
 */
package de.md.ejb.workshop.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingType;

import de.md.ejb.workshop.WorkshopBean;
import de.md.ejb.workshop.model.Workshop;

/**
 * @author dilgerma
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Remote(WorkshopBean.class)
public class WorkshopBeanImpl implements WorkshopBean {

    @PersistenceContext(name="wicket-ejb")
    private EntityManager entityManager;
    
    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#getWorkshopById(int)
     */
    @Override
    public Workshop getWorkshopById(int id) {
	List<Workshop> workshops = entityManager.createNamedQuery(Workshop.BY_ID).setParameter(1, id).getResultList();
	if(workshops.size() > 0)
	    return workshops.get(0);
	return null;
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#saveWorkshop(de.md.ejb.workshop.model.Workshop)
     */
    @Override
    public Workshop saveWorkshop(Workshop workshop) {
	if(entityManager.contains(workshop)){
	    return entityManager.merge(workshop);
	}else{
	    entityManager.persist(workshop);
	    return workshop;
	}
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#getWorkshops()
     */
    @Override
    public List<Workshop> getWorkshops() {
	return entityManager.createNamedQuery(Workshop.ALL_WORKSHOPS).getResultList();
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#removeWorkshop(de.md.ejb.workshop.model.Workshop)
     */
    @Override
    public void removeWorkshop(Workshop workshop) {
	entityManager.remove(workshop);
    }

}
