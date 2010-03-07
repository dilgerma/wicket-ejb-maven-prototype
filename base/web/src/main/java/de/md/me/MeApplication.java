/**
 * 
 */
package de.md.me;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import de.md.me.pages.IntroPage;

/**
 * Simple Application.
 * 
 * @author dilgerma
 *
 */
public class MeApplication extends WebApplication {

    
    
	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return IntroPage.class;
	}

}
