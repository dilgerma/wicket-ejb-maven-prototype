/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Project;

/**
 * IntroPage. This page holds simple description of the person.
 * 
 * @author dilgerma
 * 
 */
public class ProjectsPage extends BasePageWithMenu {

    @SpringBean
    private ProjectLoaderBean bean;

    public ProjectsPage(){
	setTitle("Projekte");
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see de.md.me.pages.SimpleMePage#initPages()
     */
    @Override
    public void initPages() {
	createMenu();
	Label label = new Label("pageTitle", getTitle());
	ListView<Project> listView = new ListView<Project>("projectsList", bean
		.loadAllProjects()) {

	    @Override
	    protected void populateItem(ListItem<Project> item) {
		item.add(new Label("title", new PropertyModel<Project>(item
			.getModelObject(), "title")));
		item.add(new Label("projectDescription",
			new PropertyModel<Project>(item.getModelObject(),
				"projectDescription")));
		item.add(new ListView("technologyList",
			new PropertyModel<Project>(item.getModelObject(),
				"technologies")) {

		    @Override
		    protected void populateItem(ListItem item) {
			
			item.add(new Label("name", new PropertyModel(item
				.getModelObject(), "name")));
		    }

		});
	    }

	};
	add(label);
	add(listView);

    }

    public void setProjectLoaderBean(ProjectLoaderBean bean) {
	this.bean = bean;
    }
}
