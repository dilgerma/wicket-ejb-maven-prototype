/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.spring.injection.annot.SpringBean;

import de.md.ejb.workshop.WorkshopBean;

/**
 * @author dilgerma
 * 
 */
public class WorkshopPage extends BasePageWithMenu {

	@SpringBean
	private WorkshopBean workshopBean;

	public WorkshopPage() {
		setTitle("Workshops");
	}

	public void setWorkshopBean(WorkshopBean bean) {
		this.workshopBean = bean;
	}

}
