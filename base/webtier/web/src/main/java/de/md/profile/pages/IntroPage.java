/**
 * 
 */
package de.md.profile.pages;

import org.apache.wicket.markup.html.basic.Label;

/**
 * IntroPage. This page holds simple description of the person.
 * 
 * @author dilgerma
 * 
 */
public class IntroPage extends BasePage {

    
    /* (non-Javadoc)
     * @see de.md.me.pages.SimpleMePage#initPages()
     */
    @Override
    public void initPages() {
	Label label = new Label("me","This is a Test ");
	add(label);
    }

}