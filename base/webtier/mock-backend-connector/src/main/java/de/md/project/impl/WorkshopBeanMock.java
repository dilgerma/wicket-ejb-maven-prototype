/**
 * 
 */
package de.md.project.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import de.md.ejb.project.model.Attachment;
import de.md.ejb.workshop.WorkshopBean;
import de.md.ejb.workshop.model.Workshop;

/**
 * @author dilgerma
 *
 */
@Service
public class WorkshopBeanMock implements WorkshopBean{

    private List<Workshop> workshops = new ArrayList<Workshop>();
    
    public WorkshopBeanMock(){
	initStaticData();
    }
    
    private void initStaticData(){
	
	List<Attachment> attachmentList = new ArrayList<Attachment>();
	Attachment att1 = new  Attachment(1,"/home/user/1.png","an image");
	Attachment att2 = new Attachment(2, "/home/user/slides.ppt","the slides");
	
	attachmentList.add(att1);
	attachmentList.add(att2);
	
	Workshop workshop = new Workshop("RCP", "This is a RCP Workshop","This is the summary",attachmentList);
	workshops.add(workshop);
    }
    
    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#getWorkshopById(int)
     */
    @Override
    public Workshop getWorkshopById(int id) {
	Iterator<Workshop> it = workshops.iterator();
	while(it.hasNext())
	{
	    Workshop ws = it.next();
	    if(id == ws.getId())
		return ws;
	}
	return null;
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#saveWorkshop(de.md.ejb.workshop.model.Workshop)
     */
    @Override
    public Workshop saveWorkshop(Workshop workshop) {
	workshops.add(workshop);
	return workshop;
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#getWorkshops()
     */
    @Override
    public List<Workshop> getWorkshops() {
	return workshops;
    }

    /* (non-Javadoc)
     * @see de.md.ejb.workshop.WorkshopBean#removeWorkshop(de.md.ejb.workshop.model.Workshop)
     */
    @Override
    public void removeWorkshop(Workshop workshop) {
	workshops.remove(workshop);
    }

}
