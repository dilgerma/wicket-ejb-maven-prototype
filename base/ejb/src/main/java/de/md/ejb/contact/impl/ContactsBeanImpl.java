/**
 * 
 */
package de.md.ejb.contact.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.md.ejb.contact.ContactsBean;
import de.md.ejb.contact.model.Contact;

/**
 * @author dilgerma
 * 
 */
@Stateless
@Local(ContactsBean.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ContactsBeanImpl implements ContactsBean {

    @PersistenceContext(name = "wicket-ejb")
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see de.md.ejb.contact.ContactsBean#getContactsByDate(java.util.Date)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getContactsByDate(Date date) {
	return entityManager.createNamedQuery("byDate").setParameter(1, date)
		.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.md.ejb.contact.ContactsBean#loadContact(long)
     */
    @Override
    @SuppressWarnings("unchecked")
    public Contact loadContact(long contactId) {
	List<Contact> resultList = entityManager.createNamedQuery(
		Contact.QUERY_BY_ID).setParameter(1, contactId)
		.getResultList();
	if (resultList.size() > 1) {
	    throw new IllegalArgumentException(
		    "More than one Instance of ContactEntity found for ID : "
			    + contactId);
	}

	if (resultList.size() == 0) {
	    return null;
	}
	return resultList.get(0);
    }

    /*
     * (non-Javadoc)
     * 
     * @seede.md.ejb.contact.ContactsBean#saveContact(de.md.ejb.contact.model.
     * ContactEntity)
     */
    @Override
    public void saveContact(Contact contact) {
	entityManager.persist(contact);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.contact.ContactsBean#removeContact(de.md.ejb.contact.model.
     * ContactEntity)
     */
    @Override
    public void removeContact(Contact entity) {
	entityManager.remove(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.contact.ContactsBean#replyTo(de.md.ejb.contact.model.ContactEntity
     * )
     */
    @Override
    public Contact replyTo(Contact entity, Contact reply) {
	Contact parent = entityManager.merge(entity);
	reply.setParent(parent);
	entityManager.persist(reply);
	return reply;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.contact.ContactsBean#loadAllContacts
     * )
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> loadAllContacts() {
	return entityManager.createNamedQuery(Contact.QUERY_ALL).getResultList();
    }
    

}
