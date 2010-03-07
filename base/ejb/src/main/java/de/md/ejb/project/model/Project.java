/**
 * 
 */
package de.md.ejb.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dilgerma
 * 
 */
@Entity
@Table(name = "projects")
@NamedQuery(name="allProjects", query="select p from Project p")
public class Project {

    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "customer")
    private String customer;
    @Column(name = "description")
    private String projectDescription;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "project_join", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tech_name"))
    private List<Technology> technologies;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id")
    private List<Attachment> attachments;

    /**
     * Custom Constructor used for JPA.
     * */
    public Project() {
    }

    public Project(String title, String customer, String projectDescription,
	    List<Technology> technologies, List<Attachment> attachments) {
	setTitle(title);
	setCustomer(customer);
	setProjectDescription(projectDescription);
	setTechnologies(technologies);
	setAttachments(attachments);

    }

    /**
     * @return the id
     */
    public long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
	this.id = id;
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
     * @return the customer
     */
    public String getCustomer() {
	return customer;
    }

    /**
     * @param customer
     *            the customer to set
     */
    public void setCustomer(String customer) {
	this.customer = customer;
    }

    /**
     * @return the projectDescription
     */
    public String getProjectDescription() {
	return projectDescription;
    }

    /**
     * @param projectDescription
     *            the projectDescription to set
     */
    public void setProjectDescription(String projectDescription) {
	this.projectDescription = projectDescription;
    }

    /**
     * @return the technologies
     */
    public List<Technology> getTechnologies() {
	return technologies;
    }

    /**
     * @param technologies
     *            the technologies to set
     */
    public void setTechnologies(List<Technology> technologies) {
	this.technologies = technologies;
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

}
