/**
 * 
 */
package de.md.profile;

import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.stereotype.Service;

import de.md.profile.pages.ProjectsPage;

/**
 * Simple Base Class for WicketApplication.
 * 
 * @author dilgerma
 * 
 */
@Service("application")
public abstract class BaseWebPageApplication extends WebApplication {

	public BaseWebPageApplication() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.wicket.protocol.http.WebApplication#init()
	 */
	@Override
	protected void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return ProjectsPage.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.wicket.protocol.http.WebApplication#newSession(org.apache.
	 * wicket.Request, org.apache.wicket.Response)
	 */
	@Override
	public Session newSession(Request request, Response response) {
		return new HomepageWebSession(request);
	}

}
