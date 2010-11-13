/**
 * 
 */
package de.md.ejb.service.jmx;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import de.md.ejb.contact.model.Contact;
import de.md.ejb.service.SessionFacade;


/**
 * @author dilgerma
 *
 */
@ManagedResource(objectName="md:name=ServiceFacadeMBean")
@Service("ServiceFacadeMBean")
public class ServiceFacadeMbean  {

    @Inject
    @Named("sessionFacade")
    private SessionFacade facade;
    
    @ManagedOperation(description="Load all Contacts")
    public List<Contact> getContact(){
	return facade.loadAllContacts();
    }
}
