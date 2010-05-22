/**
 * 
 */
package de.md.ejb.workshop;

import java.util.List;

import javax.ejb.Remote;

import de.md.ejb.workshop.model.Workshop;

/**
 * Bean to handle Workshops.
 * 
 * @author dilgerma
 * 
 */
@Remote
public interface WorkshopBean {

    public Workshop getWorkshopById(int id);

    /**
     * Method to persist / merge a Workshop.
     * 
     * If the workshop is already persisted, it is merged back into the
     * peristence context, else it is persisted. Anyway, you should always use
     * the return value.
     * 
     * @return the attached entity, the same when not yet persisted, else the
     *         merged entity.
     * */
    public Workshop saveWorkshop(Workshop workshop);

    public List<Workshop> getWorkshops();

    public void removeWorkshop(Workshop workshop);
}
