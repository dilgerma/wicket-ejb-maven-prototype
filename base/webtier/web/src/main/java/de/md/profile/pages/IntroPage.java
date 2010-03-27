/**
 * 
 */
package de.md.profile.pages;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Project;

/**
 * IntroPage. This page holds simple description of the person.
 * 
 * @author dilgerma
 * 
 */
public class IntroPage extends BasePage {

    @SpringBean
    private ProjectLoaderBean bean;

    /*
     * (non-Javadoc)
     * 
     * @see de.md.me.pages.SimpleMePage#initPages()
     */
    @Override
    public void initPages() {

	Label label = new Label("me", "This is a Test " + (bean != null));
	add(label);
	
    }

    public void setProjectLoaderBean(ProjectLoaderBean bean){
	this.bean = bean;
    }
}
