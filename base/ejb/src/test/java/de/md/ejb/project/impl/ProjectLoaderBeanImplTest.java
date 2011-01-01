/**
 * 
 */
package de.md.ejb.project.impl;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import de.md.DatabaseTestCase;
import de.md.ejb.project.model.Attachment;
import de.md.ejb.project.model.Project;
import de.md.ejb.project.model.Technology;


/**
 * @author dilgerma
 *
 */
public class ProjectLoaderBeanImplTest extends DatabaseTestCase {
 
    private ProjectLoaderBeanImpl bean;
    private EntityManager manager; 
     
    public void setUp() throws Exception{
    
	super.setUp();
	bean = new ProjectLoaderBeanImpl();
	try {
	    manager = injectEntityManager("wicket-test", "entityManager", bean);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	} 
	 
    }
    
    public void tearDown(){
	super.tearDown();
    }
    
    protected String getSqlSetUpScript() {
	return "src/main/resources/META-INF/schema.sql";
    }

    protected String getSqlTearDownScript() {
	return "src/main/resources/META-INF/schema.drop.sql";
    }
    
    protected String getDatabaseProperties(){
	return "src/main/resources/META-INF/database.properties";
    }
    
    
    public void testPersistTechnology(){
	Technology tech1 = new Technology();
	tech1.setDescription("some description");
	tech1.setName("ejb");
	manager.getTransaction().begin();
	manager.persist(tech1);
	manager.getTransaction().commit();
	manager.getTransaction().begin();
	manager.clear();
	manager.getTransaction().commit();
	manager.getTransaction().begin();
	Technology tech = manager.find(Technology.class, "ejb");
	assertEquals("some description", tech.getDescription());
	manager.getTransaction().commit();
    }
 
    public void testPersistAttachment(){
	Attachment attach1 = new Attachment();
	attach1.setId(2);
	attach1.setDescription("some attachment description");
	attach1.setPath("/home/user");
	
	
	manager.getTransaction().begin();
	manager.persist(attach1);
	manager.getTransaction().commit();
	manager.getTransaction().begin();
	manager.clear();
	manager.getTransaction().commit();
	manager.getTransaction().begin();
	Attachment att = manager.find(Attachment.class, 2);
	assertEquals("/home/user", att.getPath());
	manager.getTransaction().commit();
	
	StringWriter writer = new StringWriter();
	try {
	    traceDatabase(writer);
	    System.out.println(writer);
	} catch (Exception e) {
	   throw new RuntimeException(e);
	}
	
	
    }
    
    public void testPersistProjects() throws Exception{
	
	Technology tech1 = new Technology();
	tech1.setDescription("some description");
	tech1.setName("ejb");
	
	Technology tech2 = new Technology();
	tech2.setDescription("some description");
	tech2.setName("ejb2");
	
	Attachment attach1 = new Attachment();
	attach1.setId(2);
	attach1.setDescription("some attachment description");
	attach1.setPath("/home/user");
	
	manager.getTransaction().begin();
	
	List<Technology> technologies = new ArrayList<Technology>();
	List<Attachment> attachments = new ArrayList<Attachment>();
	
	
	technologies.add(tech1);
	technologies.add(tech2);
//	
	attachments.add(attach1);
	
	
	Project proj = new Project("RCP-Project","Anonym Versand Gmbh","some description",null,null);
	proj.setId(1);
	proj.setAttachments(attachments);
	proj.setTechnologies(technologies);
	bean.addProject(proj);
	manager.getTransaction().commit();
	
	manager = injectEntityManager("wicket-test", "entityManager", bean);
	
	manager.getTransaction().begin();
	assertEquals(1, bean.loadAllProjects().size());
	assertEquals(2, bean.loadAllProjects().get(0).getTechnologies().size());

	assertEquals(1, bean.loadAllProjects().get(0).getAttachments().size());
	manager.getTransaction().commit();
	
	Writer writer = new StringWriter();
	traceDatabase(writer);
	System.out.println(writer.toString());
    }
    

    
    
    
}
