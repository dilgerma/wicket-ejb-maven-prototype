/**
 * 
 */
package de.md.ejb.workshop.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import de.md.DatabaseTestCase;
import de.md.ejb.project.model.Attachment;
import de.md.ejb.workshop.model.Workshop;

/**
 * @author dilgerma
 * 
 */
public class WorkshopBeanImplTest extends DatabaseTestCase {

    private WorkshopBeanImpl bean;
    private EntityManager manager;

    private final Date testDate = new Date(new java.util.Date().getTime());


    public void setUp() throws Exception {
	super.setUp();
	bean = new WorkshopBeanImpl();
	try {
	    manager = injectEntityManager("wicket-test", "entityManager", bean);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}

    }

    public void tearDown() {
	super.tearDown();
    }

    public void testPersistWorkshop(){
	assertEquals(0, bean.getWorkshops().size());
	Workshop workshop = new Workshop("Wicket Workshop","This is a description","this is a rather short summary",null);
	manager.getTransaction().begin();
	bean.saveWorkshop(workshop);
	manager.getTransaction().commit();
	
	manager.clear();
	
	assertEquals(1, bean.getWorkshops().size());
    }
    
    public void testPersistWorkshopWithAttachment(){
	assertEquals(0, bean.getWorkshops().size());
	Workshop workshop = new Workshop("Wicket Workshop","This is a description","this is a rather short summary",null);
	Attachment attachment = new Attachment(1,"myPath","a description");
	Attachment attachment2 = new Attachment(2, "myPath2", "a new description");
	List<Attachment> list = new ArrayList<Attachment>();
	list.add(attachment2);
	list.add(attachment);
	workshop.setAttachments(list);
	manager.getTransaction().begin();
	bean.saveWorkshop(workshop);
	manager.getTransaction().commit();
	
	manager.clear();
	
	try {
	    manager = injectEntityManager("wicket-test", "entityManager", bean);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	
	assertEquals(1, bean.getWorkshops().size());
	
	Workshop ws = bean.getWorkshops().get(0);
	assertEquals(2, ws.getAttachments().size());
    }

    protected String getSqlSetUpScript() {
	return "src/main/resources/META-INF/schema.sql";
    }

    protected String getSqlTearDownScript() {
	return "src/main/resources/META-INF/schema.drop.sql";
    }

    protected String getDatabaseProperties() {
	return "src/main/resources/META-INF/database.properties";
    }

}
