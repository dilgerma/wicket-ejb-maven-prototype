/**
 * 
 */
package de.md.profile.pages.menu;

import java.io.Serializable;

import org.apache.wicket.Page;

/**
 * Offers Behaviour for MenuItems like TargetPage, Caption, Hover-Text.
 * 
 * @author dilgerma
 *
 */
public class MenuItem<T extends Page> implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String caption;
    private String hoverText;
    private Class<T> targetPage;
    private boolean isEnabled = true;
    private boolean isVisible = true;
    
    
    
    /**
     * @param caption
     * @param hoverText
     * @param targetPage
     */
    public MenuItem(String caption, String hoverText, Class<T> targetPage) {
	super();
	
	this.caption = caption;
	this.hoverText = hoverText;
	this.targetPage = targetPage;
    }
    /**
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }
    /**
     * @param caption the caption to set
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    /**
     * @return the hoverText
     */
    public String getHoverText() {
        return hoverText;
    }
    /**
     * @param hoverText the hoverText to set
     */
    public void setHoverText(String hoverText) {
        this.hoverText = hoverText;
    }
    /**
     * @return the targetPage
     */
    public Class<T> getTargetPage() {
        return targetPage;
    }
    /**
     * @param targetPage the targetPage to set
     */
    public void setTargetPage(Class<T> targetPage) {
        this.targetPage = targetPage;
    }
    /**
     * @return the isEnabled
     */
    public boolean isEnabled() {
        return isEnabled;
    }
    /**
     * @param isEnabled the isEnabled to set
     */
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    /**
     * @return the isVisible
     */
    public boolean isVisible() {
        return isVisible;
    }
    /**
     * @param isVisible the isVisible to set
     */
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}
