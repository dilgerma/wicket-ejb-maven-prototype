/**
 * 
 */
package de.md.ejb.contact;

import java.util.Date;
import java.util.List;

import de.md.ejb.contact.model.Contact;

/**
 * Business Interface for Contact Logic.
 * 
 * @author dilgerma
 *
 */
public interface ContactsBean {

    /**
     * Stores a new Contact-Request.
     * This can be a new Contact or a Reply to an already existing Contact-Information.
     * @param contact the Contact.
     * */
    public void saveContact(Contact contact);
    
    /**
     * Load Contact-Information.
     * @param contactId the id of a specific Contact Information
     * @return a {@link Contact}-Tree (can have 0...n children)
     * */
    public Contact loadContact(long contactId);
    
    /**
     * Get all Contacts for a specific Date.
     * 
     * @param date the Date
     * @return a List of {@link Contact}s
     * */
    public List<Contact> getContactsByDate(Date date);
    
    /**
     * Replies to the ContactInformation given as Paramter.
     * @return a managed {@link Contact}
     * @param entity the Entity to reply to.
     * @param reply the Reply
     * */
    public Contact replyTo(Contact entity, Contact reply);
    
    /**
     * Deletes a Contact and all its Replies.
     * @param entity the entity to delete.
     * */
    public void removeContact(Contact entity);
    
    /**
     * Loads all first level contacts, that means, contacts that are themselves not
     * responses.
     * @return list of non-response contacts.
     * */
    public List<Contact> loadAllContacts();
    
}
