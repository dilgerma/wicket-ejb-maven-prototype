/**
 * 
 */
package de.md.me;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;

import de.md.me.pages.IntroPage;

/**
 * Simple Base Class for WicketApplication.
 * 
 * @author dilgerma
 * 
 */
public abstract class BaseWebPageApplication extends WebApplication {

    @Inject
    @Named("WebSession")
    private HomepageWebSession session;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
	return IntroPage.class;
    }

    public HomepageWebSession getSession() {
	return session;
    }
}
