/**
 * 
 */
package de.md.profile.pages.contact;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.md.ejb.contact.model.Contact;
import de.md.profile.BasePanel;

/**
 * 
 * Panel to display contact information.
 * 
 * @author dilgerma
 * 
 */
public class ContactsDisplayPanel extends BasePanel {

    public ContactsDisplayPanel(String id) {
	super(id);
	initPanel();
    }

    @SuppressWarnings("unchecked")
    protected void initPanel() {
	final ListView listView = new ListView("contactInfo", new Model<ArrayList<Contact>>() {
	    public ArrayList<Contact> getObject() {
		return (ArrayList<Contact>)getWebSession().getContacts();
	    };
	}) {

	    private static final long serialVersionUID = 1L;

	    /*
	     * (non-Javadoc)
	     * 
	     * @see
	     * org.apache.wicket.markup.html.list.ListView#populateItem(org.
	     * apache.wicket.markup.html.list.ListItem)
	     */
	    @Override
	    protected void populateItem(ListItem item) {
		
		Contact contactItem = (Contact) item.getModelObject();
		item.add(new Label("name", new PropertyModel(contactItem,
			"name")));
		item.add(new Label("email", new PropertyModel(contactItem,
			"email")));
		item.add(new Label("text", new PropertyModel(contactItem,
			"text")));

	    }
	};
	add(listView);

    }

}
