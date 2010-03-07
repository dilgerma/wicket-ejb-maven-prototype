/**
 * 
 */
package de.md.ejb.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dilgerma
 *
 */
@Entity
@Table(name = "Technologies")
public class Technology {
    
    @Id
    @Column(name="tech_name")
    private String name;
    @Column(name="description")
    private String description;
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
}
