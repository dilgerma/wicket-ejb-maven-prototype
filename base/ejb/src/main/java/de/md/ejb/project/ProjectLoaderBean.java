/**
 * 
 */
package de.md.ejb.project;

import java.util.List;

import de.md.ejb.project.model.Project;

/**
 * @author dilgerma
 *
 */
public interface ProjectLoaderBean {

     public Project loadProjectData(long projectId);
    
    public List<Project> loadAllProjects();
    
    public Project addProject(Project project);
    
    public void removeProject(Project project);
}
