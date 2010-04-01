/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

/**
 * ContactsPage Implementation.
 * 
 * @author dilgerma
 * 
 */
public class ContactsPage extends BasePageWithMenu {

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
	add(new FeedbackPanel("contactsFormFeedback"));
	Form form = new Form("contactsForm") {
	    protected void onSubmit() {
	    };
	    
	    /* (non-Javadoc)
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
	add(emailField);
	
	final DropDownChoice reasonField = new DropDownChoice("reason");
	reasonField.setRequired(true);
	add(reasonField);
	
	final TextArea textArea = new TextArea("text");
	textArea.setRequired(true);
	add(textArea);
	
	form.add(new SubmitLink("contactSubmit") {
	   
	    
	    /* (non-Javadoc)
	     * @see org.apache.wicket.markup.html.form.Button#onSubmit()
	     */
	    @Override
	    public void onSubmit() {
		nameField.setVisibilityAllowed(true);
		nameField.setVisible(false);
	    }
	    
	});

	add(form);
    }

}
