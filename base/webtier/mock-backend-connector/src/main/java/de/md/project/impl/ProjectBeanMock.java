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
import de.md.ejb.project.model.Project;

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

}
