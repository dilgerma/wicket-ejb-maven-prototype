/**
 * 
 */
package de.md.profile.pages;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.wicket.Request;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import de.md.profile.HomePageApplication;
import de.md.profile.HomepageWebSession;

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
    public BasePage() {
	initPages();
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
