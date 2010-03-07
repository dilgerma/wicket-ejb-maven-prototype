/**
 * 
 */
package de.md.me.pages;

import org.apache.wicket.markup.html.WebPage;

/**
 * Base Class for all Wicket Pages.
 * 
 * @author dilgerma
 *
 */
public abstract class SimpleMePage extends WebPage {

    public SimpleMePage(){
	initPages();
    }
    
    public abstract void initPages();
}
