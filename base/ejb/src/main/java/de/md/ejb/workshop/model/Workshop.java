/**
 * 
 */
package de.md.ejb.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import de.md.ejb.project.model.Attachment;

/**
 * Entity for Workshops.
 * 
 * @author dilgerma
 * 
 */
@Table(name = "workshop_table")
@Entity
@NamedQueries({
	@NamedQuery(name = Workshop.ALL_WORKSHOPS, query = "select w from Workshop w"),
	@NamedQuery(name = Workshop.BY_ID, query = "select w from Workshop w where w.id=?1") })
public class Workshop {

    public static final String ALL_WORKSHOPS = "allWorkshops";
    public static final String BY_ID = "ws_byId";

    @Id
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "summary")
    private String summary;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "workshop_attachment", joinColumns = @JoinColumn(name = "workshop_id"), inverseJoinColumns = @JoinColumn(name = "attachment_id"))
    private List<Attachment> attachments = new ArrayList<Attachment>();

    /**
     * DEfault Constructor
     * */
    public Workshop(){}
    
    /**
     * @param title
     * @param description
     * @param summary
     * @param attachments
     */
    public Workshop(String title, String description, String summary,
	    List<Attachment> attachments) {
	super();
	this.title = title;
	this.description = description;
	this.summary = summary;
	this.attachments = attachments;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
	return summary;
    }

    /**
     * @param summary
     *            the summary to set
     */
    public void setSummary(String summary) {
	this.summary = summary;
    }

    /**
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
	return attachments;
    }

    /**
     * @param attachments
     *            the attachments to set
     */
    public void setAttachments(List<Attachment> attachments) {
	this.attachments = attachments;
    }

    public void setId(int id){
	this.id = id;
    }
    
    public int getId(){
	return id;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((attachments == null) ? 0 : attachments.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((summary == null) ? 0 : summary.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Workshop other = (Workshop) obj;
	if (attachments == null) {
	    if (other.attachments != null)
		return false;
	} else if (!attachments.equals(other.attachments))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (summary == null) {
	    if (other.summary != null)
		return false;
	} else if (!summary.equals(other.summary))
	    return false;
	if (title == null) {
	    if (other.title != null)
		return false;
	} else if (!title.equals(other.title))
	    return false;
	return true;
    }

}
