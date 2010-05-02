/**
 * 
 */
package de.md.profile.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;

import de.md.profile.pages.menu.MenuItem;
import de.md.profile.pages.menu.MenuPanel;

/**
 * Base Page which renders the Application Menu.
 * 
 * @author dilgerma
 * 
 */
public abstract class BasePageWithMenu extends BasePage {

    /**
     * Creates the MenuComponent.
     * @return the MenuComponent.
     * */
    protected void createMenu() {
	add(new MenuPanel("menu", createMenuItems()));
    }

    /**
     * creates MenuItems.
     * 
     * @return a list of MenuItems to render.
     * 
     * */
    protected List<MenuItem<? extends Page>> createMenuItems() {
	List<MenuItem<? extends Page>> itemList = new ArrayList<MenuItem<? extends Page>>();
	MenuItem<ProjectsPage> projectsPage = new MenuItem<ProjectsPage>(
		"Projekte", "Aktuelle Projekte", ProjectsPage.class);
	MenuItem<ProjectsPage> blog = new MenuItem<ProjectsPage>(
		"Blog", "Blog", ProjectsPage.class);
	blog.setEnabled(false);
	MenuItem<ProjectsPage> workshop = new MenuItem<ProjectsPage>(
		"Schulungen", "Schulungen", ProjectsPage.class);
	workshop.setEnabled(false);
	MenuItem<ContactsPage> contactsPage = new MenuItem<ContactsPage>(
		"Kontakt", "Kontakt", ContactsPage.class);
	
	itemList.add(projectsPage);
	itemList.add(blog);
	itemList.add(workshop);
	itemList.add(contactsPage);
	return itemList;
    }
    
    /**
     * Initializes Menu-Navigation.
     * If you do not need any menu, just do not call super-Implementation
     * in Subclasses.
     * */
    @Override
    public void initPages() {
	createMenu();
	add(new Label("pageTitle", getTitle()));
    }
}
