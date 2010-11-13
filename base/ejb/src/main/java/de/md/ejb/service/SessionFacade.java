/**
 * 
 */
package de.md.ejb.service;

import java.util.Date;
import java.util.List;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import de.md.ejb.contact.model.Contact;
import de.md.ejb.project.model.Project;

/**
 * SessionFacade to handle Business Requests to Middletier. Every Access to EJB
 * must go through this Facade.
 * 
 * @author dilgerma
 * 
 */
@ManagedResource(objectName="WebMBean")
public interface SessionFacade {

    /*
     * ContactRelated
     */
    @ManagedOperation
    public void saveContact(Contact contact);

    public List<Contact> getContactsByDate(Date date);

    public Contact replyTo(Contact parent, Contact response);

    public void removeContact(Contact contact);

    public List<Contact> loadAllContacts();

    /*
     * Project Related
     */
    public Project loadProjectData(long projectId);

    public List<Project> loadAllProjects();

    public Project addProject(Project project);

    public void removeProject(Project project);

}
