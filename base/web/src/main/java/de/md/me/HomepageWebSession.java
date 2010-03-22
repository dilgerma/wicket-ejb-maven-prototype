/**
 * 
 */
package de.md.me;

import javax.inject.Named;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

/**
 * Implementation of WebSession.
 * 
 * @author dilgerma
 *
 */
@Named("WebSession")
public class HomepageWebSession extends WebSession {

    /**
     * @param request
     */
    public HomepageWebSession(Request request) {
	super(request);
	// TODO Auto-generated constructor stub
    }

   

}
