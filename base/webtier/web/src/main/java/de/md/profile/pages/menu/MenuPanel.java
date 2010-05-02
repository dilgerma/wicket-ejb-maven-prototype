/**
 * 
 */
package de.md.profile.pages.menu;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * 
 * Panel to display the Menu Hierarchy of a {@link Page}
 * @see MenuItem
 * @author dilgerma
 *
 */
public class MenuPanel extends Panel {

    private List<MenuItem<? extends Page>> items;
    
    /**
     * @param id the Id
     * @param items the MenuItems, may not be null
     * @throws IllegalArgumentException if items are null
     */
    public MenuPanel(String id, List<MenuItem<? extends Page>> items) {
	super(id);
	if(items == null){
	    throw new IllegalArgumentException("MenuItems may not be null");
	}
	this.items = items;
	initPanel();
    }
    
    protected void initPanel(){
	add(new MenuRenderer("menuItem",items));
    }
    

}
