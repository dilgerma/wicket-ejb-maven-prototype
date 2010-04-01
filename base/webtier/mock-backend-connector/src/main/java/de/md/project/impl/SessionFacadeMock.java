/**
 * 
 */
package de.md.project.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.md.ejb.contact.ContactsBean;
import de.md.ejb.contact.model.Contact;
import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Project;
import de.md.ejb.service.SessionFacade;

/**
 * @author dilgerma
 *
 */
@Service
public class SessionFacadeMock implements SessionFacade {

    @Autowired
    private ProjectLoaderBean projectBean;
    @Autowired
    private ContactsBean contactBean;
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#getContactsByDate(java.util.Date)
     */
    @Override
    public List<Contact> getContactsByDate(Date arg0) {
	return contactBean.getContactsByDate(arg0);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#loadAllContacts()
     */
    @Override
    public List<Contact> loadAllContacts() {
	return contactBean.loadAllContacts();
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#removeContact(de.md.ejb.contact.model.Contact)
     */
    @Override
    public void removeContact(Contact arg0) {
	checkId(arg0);
	contactBean.removeContact(arg0);
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#replyTo(de.md.ejb.contact.model.Contact, de.md.ejb.contact.model.Contact)
     */
    @Override
    public Contact replyTo(Contact arg0, Contact arg1) {
	checkId(arg1);
	return contactBean.replyTo(arg0, arg1);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#saveContact(de.md.ejb.contact.model.Contact)
     */
    @Override
    public void saveContact(Contact arg0) {
	checkId(arg0);
	contactBean.saveContact(arg0);
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#addProject(de.md.ejb.project.model.Project)
     */
    @Override
    public Project addProject(Project arg0) {
	return projectBean.addProject(arg0);
    }

    

    /* (non-Javadoc)
     * @see de.md.ejb.service.SessionFacade#removeProject(de.md.ejb.project.model.Project)
     */
    @Override
    public void removeProject(Project arg0) {
	checkId(arg0);
	projectBean.removeProject(arg0);
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
    public Project loadProjectData(long arg0) {
	return projectBean.loadProjectData(arg0);
    }
 
    
    public void setContactsBean(ContactsBean bean){
	this.contactBean = bean;
    }
    
    public void setProjectLoaderBean(ProjectLoaderBean bean){
	this.projectBean = bean;
    }
    
    protected void checkId(Object p){
	IDChecker.WithObject(p).WithNewIdIfNull(new Random().nextLong());
    }

}
