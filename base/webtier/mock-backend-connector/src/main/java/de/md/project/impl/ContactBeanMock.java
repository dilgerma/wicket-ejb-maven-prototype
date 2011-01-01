/**
 * 
 */
package de.md.project.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import de.md.ejb.contact.ContactsBean;
import de.md.ejb.contact.model.Contact;
import de.md.ejb.contact.model.ContactReason;

/**
 * @author dilgerma
 * 
 */
@Service
public class ContactBeanMock implements ContactsBean {

	private Map<Long, Contact> contacts = new HashMap<Long, Contact>();

	public ContactBeanMock() {
		initMockData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.md.ejb.contact.ContactsBean#getContactsByDate(java.util.Date)
	 */
	@Override
	public List<Contact> getContactsByDate(Date arg0) {

		List<Contact> resultList = new ArrayList<Contact>();

		for (Contact c : contacts.values()) {
			if (c.getCreationDate().equals(arg0)) {
				resultList.add(c);
			}
		}
		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.md.ejb.contact.ContactsBean#loadAllContacts()
	 */
	@Override
	public List<Contact> loadAllContacts() {
		List<Contact> result = new ArrayList<Contact>();
		for (Contact c : contacts.values()) {
			if (c.hasParent() == false) {
				result.add(c);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.md.ejb.contact.ContactsBean#loadContact(long)
	 */
	@Override
	public Contact loadContact(long arg0) {
		return contacts.get(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.md.ejb.contact.ContactsBean#removeContact(de.md.ejb.contact.model.
	 * Contact)
	 */
	@Override
	public void removeContact(Contact arg0) {
		contacts.remove(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.md.ejb.contact.ContactsBean#replyTo(de.md.ejb.contact.model.Contact,
	 * de.md.ejb.contact.model.Contact)
	 */
	@Override
	public Contact replyTo(Contact arg0, Contact arg1) {
		if (!contacts.values().contains(arg0)) {
			throw new IllegalStateException("Comment not available");
		}

		arg1.setParent(arg0);
		contacts.put(arg1.getId(), arg1);
		return arg1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.md.ejb.contact.ContactsBean#saveContact(de.md.ejb.contact.model.Contact
	 * )
	 */
	@Override
	public void saveContact(Contact arg0) {
		contacts.put(arg0.getId(), arg0);
	}

	private void initMockData() {
		Contact c1 = new Contact("Hans Mueller", "hans.mueller@web.de",
				new Date(), ContactReason.COMMENT, "nette Seite");
		c1.setId(1l);
		Contact c2 = new Contact("Gerda Weibel", "gerda.weibel@gmx.de",
				new Date(), ContactReason.COMMENT, "Gefällt mir, das Layout");
		c2.setId(2l);

		contacts.put(c1.getId(), c1);
		contacts.put(c2.getId(), c2);
	}
}
