/**
 * 
 */
package de.md.profile;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * BasePanel to provide common functionality.
 * 
 * @author dilgerma
 * 
 */
public class BasePanel extends Panel {

	/**
	 * Base Constructor.
	 * 
	 * Just delegates to super Implementation.
	 * 
	 * @param id
	 *            the Id
	 * */
	public BasePanel(String id) {
		super(id);
	}

	/**
	 * Base Constructor.
	 * 
	 * Just delegates to super Implementation.
	 * 
	 * @param id
	 *            the Id
	 * @param model
	 *            the Model Implementation
	 * */
	public BasePanel(String id, IModel model) {
		super(id, model);
	}

	public HomepageWebSession getWebSession() {
		return (HomepageWebSession) Session.get();
	}
}
