/**
 * 
 */
package de.md.me.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebSession;

import de.md.me.HomePageApplication;
import de.md.me.HomepageWebSession;

/**
 * Base Class for all Wicket Pages.
 * 
 * @author dilgerma
 *
 */
public abstract class BasePage extends WebPage {

    /**
     * Custom Constructor.
     * */
    public BasePage(){
	initPages();
    }
    
    /**
     * Method used to init the Pages.
     * */
    public abstract void initPages();
    
    /**
     * @return the Application
     * */
    public HomePageApplication getWebApplication(){
	return (HomePageApplication)getApplication();
    }
    
    
    public HomepageWebSession getWebSession(){
	return (HomepageWebSession) getSession();
    }
}