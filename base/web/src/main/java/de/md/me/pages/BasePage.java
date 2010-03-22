/**
 * 
 */
package de.md.me.pages;

import org.apache.wicket.markup.html.WebPage;

import de.md.me.HomePageApplication;
import de.md.me.HomepageWebSession;

/**
 * Base Class for all Wicket Pages.
 * 
 * @author dilgerma
 *
 */
public abstract class BasePage extends WebPage {

    public BasePage(){
	initPages();
    }
    
    public abstract void initPages();
    
    public HomePageApplication getWebApplication(){
	return (HomePageApplication)getApplication();
    }
    
    public HomepageWebSession getWebSession(){
	return getWebApplication().getSession();
    }
}
