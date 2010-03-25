/**
 * 
 */
package de.md.me;


import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;

import de.md.me.pages.IntroPage;

/**
 * Simple Base Class for WicketApplication.
 * 
 * @author dilgerma
 * 
 */
public abstract class BaseWebPageApplication extends WebApplication {

    private GenericApplicationContext context;

    public BaseWebPageApplication(){
    }
    
    /* (non-Javadoc)
     * @see org.apache.wicket.protocol.http.WebApplication#init()
     */
    @Override
    protected void init() {
        super.init();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
	return IntroPage.class;
    }

   
    
    /* (non-Javadoc)
     * @see org.apache.wicket.protocol.http.WebApplication#newSession(org.apache.wicket.Request, org.apache.wicket.Response)
     */
    @Override
    public Session newSession(Request request, Response response) {
        return new HomepageWebSession(request);
    }
        
}
