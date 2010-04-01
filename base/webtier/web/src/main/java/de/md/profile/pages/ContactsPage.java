/**
 * 
 */
package de.md.profile.pages;

import java.util.Arrays;
import java.util.Date;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.md.ejb.contact.model.Contact;
import de.md.ejb.contact.model.ContactReason;
import de.md.ejb.service.SessionFacade;

/**
 * ContactsPage Implementation.
 * 
 * @author dilgerma
 * 
 */
public class ContactsPage extends BasePageWithMenu {

    @SpringBean
    private SessionFacade facade;

    public ContactsPage() {
	setTitle("Kontakt");
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

	add(new FeedbackPanel("contactsFormFeedback"));
	final Form form = new Form("contactsForm",
		new CompoundPropertyModel<Contact>(contact)) {
	    protected void onSubmit() {
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

	final DropDownChoice reasonField = new DropDownChoice("reason", Arrays
		.asList(ContactReason.values()));
	reasonField.setRequired(true);
	form.add(reasonField);

	final TextArea textArea = new TextArea("text");
	textArea.setRequired(true);
	form.add(textArea);

	form.add(new SubmitLink("contactSubmit") {

	    /*
	     * (non-Javadoc)
	     * 
	     * @see org.apache.wicket.markup.html.form.Button#onSubmit()
	     */
	    @Override
	    public void onSubmit() {
		facade.saveContact((Contact)form.getModelObject());
	    }

	});

	add(form);
    }

    /**
     * @return
     */
    private Contact newContact() {
	Contact co = new Contact("", "", new Date(), ContactReason.COMMENT, "");
	return co;
    }

}
