/**
 * 
 */
package de.md.project.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Attachment;
import de.md.ejb.project.model.Project;
import de.md.ejb.project.model.Technology;

/**
 * Simple Frontend Mock, that allows development
 * without any DB, EJB on a simple Tomcat-Instance.
 * 
 * @author dilgerma
 *
 */
@Service
public class ProjectBeanMock implements ProjectLoaderBean {
    
    private Map<Long, Project> projects = new HashMap<Long, Project>();

    public ProjectBeanMock(){
	initMockData();
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.project.ProjectLoaderBean#addProject(de.md.ejb.project.model.Project)
     */
    @Override
    public Project addProject(Project project) {
	projects.put(project.getId(), project);
	return project;
    }

    /* (non-Javadoc)
     * @see de.md.ejb.project.ProjectLoaderBean#loadAllProjects()
     */
    @Override
    public List<Project> loadAllProjects() {
	return new ArrayList<Project>(projects.values());
    }

    /* (non-Javadoc)
     * @see de.md.ejb.project.ProjectLoaderBean#loadProjectData(long)
     */
    @Override
    public Project loadProjectData(long projectId) {
	return projects.get(projectId);
    }

    /* (non-Javadoc)
     * @see de.md.ejb.project.ProjectLoaderBean#removeProject(de.md.ejb.project.model.Project)
     */
    @Override
    public void removeProject(Project project) {
	projects.remove(project);
    }

    private void initMockData(){
	
	List<Technology> techList1 = new ArrayList<Technology>();
	Technology jsfTech = new Technology("JSF");
	Technology ejbTech1 = new Technology("EJB3.1");
	Technology IvyTech = new Technology("Ivy");
	techList1.add(jsfTech);
	techList1.add(ejbTech1);
	techList1.add(IvyTech);
	
	List<Technology> techList2 = new ArrayList<Technology>();
	Technology wicketTech = new Technology("Wicket");
	Technology ejbTech = new Technology("EJB3.1");
	Technology mavenTech = new Technology("Maven2");
	techList2.add(wicketTech);
	techList2.add(ejbTech);
	techList2.add(mavenTech);
	
	
	
	
	Project project = new Project("EJB Implementation", "Insurance Nuremberg", "Project Implementing Business Logic",techList1, new ArrayList<Attachment>());
	project.setId(1);
	Project project2 = new Project("Wicket Implementation", "Telecommunication Munich", "First Wicket Implementation",techList2, new ArrayList<Attachment>());
	project2.setId(2);
	addProject(project);
	addProject(project2);
    }
}
