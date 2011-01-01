/**
 * 
 */
package de.md.profile;

import java.util.List;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

import de.md.ejb.contact.model.Contact;

/**
 * Implementation of WebSession.
 * 
 * @author dilgerma
 * 
 */
public class HomepageWebSession extends WebSession {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private List<Contact> contactsList;

	/**
	 * @param request
	 */
	public HomepageWebSession(Request request) {
		super(request);
	}

	/**
	 * @return a List of common {@link Contact}s.
	 * */
	public List<Contact> getContacts() {
		return contactsList;
	}

	/**
	 * Setter for Contacts.
	 * 
	 * @param contactsList
	 *            a List of contacts to store in a Session.
	 * */
	public void setContacts(List<Contact> contactsList) {
		this.contactsList = contactsList;
	}

}
