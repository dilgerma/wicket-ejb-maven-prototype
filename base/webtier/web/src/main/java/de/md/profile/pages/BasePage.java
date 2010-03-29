/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.markup.html.WebPage;
import org.hibernate.property.Getter;

import de.md.profile.HomePageApplication;
import de.md.profile.HomepageWebSession;

/**
 * Base Class for all Wicket Pages.
 * 
 * @author dilgerma
 * 
 */
public abstract class BasePage extends WebPage {

    protected String title;
    
    /**
     * Custom Constructor.
     * */
    public BasePage() {
	initPages();	
    }

    
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title the PageTitle
     * */
    protected void setTitle(String title){
	this.title = title;
    }



    /**
     * Method used to init the Pages.
     * */
    public abstract void initPages();

    /**
     * @return the Application
     * */
    public HomePageApplication getWebApplication() {
	return (HomePageApplication) getApplication();
    }

    public HomepageWebSession getWebSession() {
	return (HomepageWebSession) getSession();
    }

}
