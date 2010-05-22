/**
 * 
 */
package de.md.ejb.contact.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.md.ejb.util.DateUtil;

/**
 * Entity for storing Contact Data.
 * 
 * @author dilgerma
 * 
 */
@Entity
@Table(name = "contacts_table")
@NamedQueries( {
	@NamedQuery(name = Contact.QUERY_BY_DATE, query = "select e from Contact e where e.creationDate=?1"),
	@NamedQuery(name = Contact.QUERY_BY_ID, query = "select e from Contact e where e.id=?1"),
	@NamedQuery(name = Contact.QUERY_ALL, query = "select e from Contact e") })
public class Contact implements Serializable {

    public static final String QUERY_BY_DATE = "byDate";
    public static final String QUERY_BY_ID = "byId";
    public static final String QUERY_ALL = "all";

    @Id
    @SequenceGenerator(name = "contactSequenceGen", sequenceName = "contactSequence")
    @GeneratedValue(generator = "contactSequenceGen", strategy = GenerationType.SEQUENCE)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "name")
    private String name;
    @Column(name = "reason")
    @Enumerated(EnumType.ORDINAL)
    private ContactReason reason;
    @Column(name = "text")
    private String text;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Contact parent;

    /**
     * Custom Constructor used by JPA.
     * */
    public Contact() {
    }

    /**
     * @param creationDate
     *            the date, seconds and milliseconds get erased!
     * @param reason
     * @param text
     * @param email
     */
    public Contact(String name, String email, Date creationDate,
	    ContactReason reason, String text) {
	super();
	this.name = name;
	this.creationDate = DateUtil.clearFieldsDate(creationDate,
		Calendar.MILLISECOND, Calendar.SECOND);
	this.creationDate = creationDate;
	this.reason = reason;
	this.text = text;
	this.email = email;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
	return creationDate;
    }

    /**
     * @return the reason
     */
    public ContactReason getReason() {
	return reason;
    }

    /**
     * @return the text
     */
    public String getText() {
	return text;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * @return the ID
     * */
    public long getId() {
	return id;
    }

    /**
     * @return the Name
     * */
    public String getName() {
	return name;
    }

    /**
     * @return true if child not null, false else
     * */
    public boolean hasParent() {
	return parent != null;
    }

    /**
     * @return a {@link Contact}, that is the answer on this contact or null.
     * */
    public Contact getParent() {
	return parent;
    }

    /**
     * @param entity
     *            the Entity that is the Response
     * */
    public void setParent(Contact entity) {
	this.parent = entity;
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
		+ ((creationDate == null) ? 0 : creationDate.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((reason == null) ? 0 : reason.hashCode());
	result = prime * result + ((text == null) ? 0 : text.hashCode());
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
	Contact other = (Contact) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (id != other.id)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (reason == null) {
	    if (other.reason != null)
		return false;
	} else if (!reason.equals(other.reason))
	    return false;
	if (text == null) {
	    if (other.text != null)
		return false;
	} else if (!text.equals(other.text))
	    return false;
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Contact [child=" + parent + ", creationDate=" + creationDate
		+ ", email=" + email + ", id=" + id + ", name=" + name
		+ ", reason=" + reason + ", text=" + text + "]";
    }

}
