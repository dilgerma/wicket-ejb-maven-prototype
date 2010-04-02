/**
 * 
 */
package de.md.profile.pages.contact;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import de.md.ejb.contact.model.Contact;

/**
 * 
 * Panel to display contact information.
 * 
 * @author dilgerma
 *
 */
public class ContactsDisplayPanel extends Panel {

    private List<Contact> contactsList;
    
    public ContactsDisplayPanel(String id, List<Contact> contactList){
	super(id);
	this.contactsList = contactList;
	initPanel(this.contactsList);
    }
    
    protected void initPanel(List<Contact> contactList){
	add(new ListView("contactInfo", contactList){
	  /* (non-Javadoc)
	     * @see org.apache.wicket.markup.html.list.ListView#populateItem(org.apache.wicket.markup.html.list.ListItem)
	     */
	    @Override
	    protected void populateItem(ListItem item) {
	      Contact contactItem = (Contact)item.getModelObject();
	      item.add(new Label("name", new PropertyModel(contactItem,"name")));
	      item.add(new Label("email", new PropertyModel(contactItem,"email")));
	      item.add(new Label("text", new PropertyModel(contactItem,"text")));
		     
	    }  
	});
    }
    

}
