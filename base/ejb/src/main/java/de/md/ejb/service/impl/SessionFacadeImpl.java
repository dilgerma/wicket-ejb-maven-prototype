/**
 * 
 */
package de.md.ejb.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.jmx.export.annotation.ManagedResource;

import de.md.ejb.contact.ContactsBean;
import de.md.ejb.contact.model.Contact;
import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Project;
import de.md.ejb.service.SessionFacade;

/**
 * @author dilgerma
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local(SessionFacade.class)
@ManagedResource(objectName = "bean:name=simpleBean", description = "A sample JMX-managed bean")
public class SessionFacadeImpl implements SessionFacade {

    @EJB
    private ContactsBean contactsBean;
    @EJB
    private ProjectLoaderBean projectBean;
    

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#removeProject(de.md.ejb.project.model.Project)
     */
    @Override
    public void removeProject(Project project) {
	projectBean.removeProject(project);
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#addProject(de.md.ejb.project.model.Project)
     */
    @Override
    public Project addProject(Project project) {
	return projectBean.addProject(project);
    }

   

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#loadAllProjects()
     */
    @Override
    public List<Project> loadAllProjects() {
	return projectBean.loadAllProjects();
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#loadProjectData(long)
     */
    @Override
    public Project loadProjectData(long projectId) {
	return projectBean.loadProjectData(projectId);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#removeContact(de.md.ejb.contact.model.Contact)
     */
    @Override
    public void removeContact(Contact contact) {
	contactsBean.removeContact(contact);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#replyTo(de.md.ejb.contact.model.Contact, de.md.ejb.contact.model.Contact)
     */
    @Override
    public Contact replyTo(Contact parent, Contact response) {
	return contactsBean.replyTo(parent, response);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#saveContact(de.md.ejb.contact.model.Contact)
     */
    @Override
    public void saveContact(Contact contact) {
	contactsBean.saveContact(contact);
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#getContactsByDate(java.util.Date)
     */
    @Override
    public List<Contact> getContactsByDate(Date date) {
	return contactsBean.getContactsByDate(date);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#loadAllContacts()
     */
    @Override
    public List<Contact> loadAllContacts() {
	return contactsBean.loadAllContacts();
    }

}
