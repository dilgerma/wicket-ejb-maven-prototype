/**
 * 
 */
package de.md.profile.pages;

import java.util.Arrays;
import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.md.ejb.contact.model.Contact;
import de.md.ejb.contact.model.ContactReason;
import de.md.ejb.service.SessionFacade;
import de.md.profile.pages.contact.ContactsDisplayPanel;

/**
 * ContactsPage Implementation.
 * 
 * @author dilgerma
 * 
 */
public class ContactsPage extends BasePageWithMenu {

	@SpringBean
	private SessionFacade facade;
	private ContactsDisplayPanel contactDisplayPanel;

	public ContactsPage() {
		setTitle("Kontakt");
		if (getWebSession().getContacts() == null) {
			getWebSession().setContacts(facade.loadAllContacts());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.md.profile.pages.BasePage#initPages()
	 */
	@Override
	public void initPages() {
		super.initPages();

		Contact contact = newContact();
		FeedbackPanel feedbackPanel = new FeedbackPanel("contactsFormFeedback");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		final Form form = new Form("contactsForm",
				new CompoundPropertyModel<Contact>(contact)) {
			protected void onSubmit() {
				// omitted
			};

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.apache.wicket.MarkupContainer#isTransparentResolver()
			 */
			@Override
			public boolean isTransparentResolver() {
				return true;
			}
		};
		form.setOutputMarkupId(true);

		final TextField nameField = new TextField("name");
		nameField.setRequired(true);
		form.add(nameField);

		final TextField emailField = new TextField("email");
		emailField.setRequired(true);
		form.add(emailField);

		final DropDownChoice reasonField = new DropDownChoice("reason",
				Arrays.asList(ContactReason.values()));
		reasonField.setRequired(true);
		form.add(reasonField);

		final TextArea textArea = new TextArea("text");
		textArea.setRequired(true);
		form.add(textArea);

		form.add(new AjaxSubmitLink("contactSubmit", form) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.apache.wicket.markup.html.form.Button#onSubmit()
			 */
			@Override
			public void onSubmit(AjaxRequestTarget target, Form form) {
				facade.saveContact((Contact) form.getModelObject());
				getWebSession().setContacts(facade.loadAllContacts());
				target.addComponent(contactDisplayPanel);
				form.getModel().setObject(newContact());
			}

		});

		add(form);
		contactDisplayPanel = new ContactsDisplayPanel("contacts");
		contactDisplayPanel.setOutputMarkupId(true);
		add(contactDisplayPanel);
	}

	/**
	 * @return
	 */
	private Contact newContact() {
		Contact co = new Contact("", "", new Date(), ContactReason.COMMENT, "");
		return co;
	}

}
