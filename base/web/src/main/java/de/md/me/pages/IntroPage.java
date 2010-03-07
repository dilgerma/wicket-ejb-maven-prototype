/**
 * 
 */
package de.md.me.pages;

import org.apache.wicket.markup.html.basic.Label;

/**
 * IntroPage. This page holds simple description of the person.
 * 
 * @author dilgerma
 * 
 */
public class IntroPage extends SimpleMePage {

    /* (non-Javadoc)
     * @see de.md.me.pages.SimpleMePage#initPages()
     */
    @Override
    public void initPages() {
	Label label = new Label("me","hallo welt");
	add(label);
	
    }

}
