/**
 * 
 */
package de.md.ejb.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dilgerma
 *
 */
@Entity
@Table(name="project_attachment")
public class Attachment implements Serializable {
    @Id
    private int id;
    @Column(name="path")
    private String path;
    @Column(name="description")
    private String description;
    
    public Attachment(){}
    
    /**
     * @param id
     * @param path
     */
    public Attachment(int id, String path, String description) {
	super();
	this.id = id;
	this.path = path;
	this.description = description;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
