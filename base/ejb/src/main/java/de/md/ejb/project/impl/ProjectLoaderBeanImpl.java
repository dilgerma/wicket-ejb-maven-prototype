/**
 * 
 */
package de.md.ejb.project.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import de.md.ejb.project.ProjectLoaderBean;
import de.md.ejb.project.model.Project;

/**
 * @author dilgerma
 * 
 */
@Stateless
@Local(ProjectLoaderBean.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProjectLoaderBeanImpl implements ProjectLoaderBean {

    @PersistenceContext(name = "wicket-ejb")
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.project.ProjectLoaderBean#addProject(de.md.ejb.project.model
     * .Project)
     */
    @Override
    public Project addProject(Project project) {
	if (loadProjectData(project.getId()) == null) {
	    entityManager.persist(project);
	    return project;
	} else {
	   return entityManager.merge(project);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.md.ejb.project.ProjectLoaderBean#loadAllProjects()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Project> loadAllProjects() {
	return entityManager.createNamedQuery("allProjects").getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.project.ProjectLoaderBean#loadProjectData(java.lang.String)
     */
    @Override
    public Project loadProjectData(long projectId) {
	return entityManager.find(Project.class, projectId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.md.ejb.project.ProjectLoaderBean#removeProject(de.md.ejb.project.model
     * .Project)
     */
    @Override
    public void removeProject(Project project) {
	entityManager.remove(project);
    }

}
