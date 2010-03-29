/**
 * 
 */
package de.md.profile.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.Page;

import de.md.profile.pages.menu.MenuItem;
import de.md.profile.pages.menu.MenuRenderer;

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
	add(new MenuRenderer("menu", createMenuItems()));
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
	itemList.add(projectsPage);
	itemList.add(blog);
	itemList.add(workshop);
	return itemList;
    }
}
