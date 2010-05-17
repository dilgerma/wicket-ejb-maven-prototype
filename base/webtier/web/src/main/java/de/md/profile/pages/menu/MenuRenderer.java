/**
 * 
 */
package de.md.profile.pages.menu;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * Renderer to Render a List of {@link MenuItem}s.
 * 
 * @author dilgerma
 * 
 */
public class MenuRenderer extends RepeatingView {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<MenuItem<? extends Page>> itemsList;

    /**
     * @param id
     * @param model
     */
    public MenuRenderer(String id, List<MenuItem<? extends Page>> items) {
	super(id);
	if (items == null) {
	    throw new IllegalArgumentException(
		    "Items in MenuRenderer may not be null");
	}
	this.itemsList = items;
	renderMenu();
    }

    public void renderMenu() {

	for (MenuItem<? extends Page> item : itemsList) {
	    if (item.isVisible()) {
		// adding new hierarchy level
		WebMarkupContainer parent = new WebMarkupContainer(newChildId());
		add(parent);
		BookmarkablePageLink bmLink = new BookmarkablePageLink("link",
			item.getTargetPage());
		bmLink.setEnabled(item.isEnabled());
		parent.add(bmLink);
		bmLink.add(new Label("caption", item.getCaption()));
	
	    }
	}

    }

}
