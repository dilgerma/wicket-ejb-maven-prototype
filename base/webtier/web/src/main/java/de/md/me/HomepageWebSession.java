/**
 * 
 */
package de.md.me;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

/**
 * Implementation of WebSession.
 * 
 * @author dilgerma
 *
 */
public class HomepageWebSession extends WebSession {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param request
     */
    public HomepageWebSession(Request request) {
	super(request);
    }

 }
