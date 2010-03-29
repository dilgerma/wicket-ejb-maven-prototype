/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.markup.html.basic.Label;

/**
 * ContactsPage Implementation.
 * 
 * @author dilgerma
 *
 */
public class ContactsPage extends BasePageWithMenu {

    public ContactsPage(){
	setTitle("Kontakt");
    }
    
    /* (non-Javadoc)
     * @see de.md.profile.pages.BasePage#initPages()
     */
    @Override
    public void initPages() {
	createMenu();
	add(new Label("pageTitle", getTitle()));
    }

}
