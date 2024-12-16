package mvc.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import mvc.Model.BL.Section;
import mvc.Model.BL.Status;
import mvc.Model.DAL.Sections.ISectionDAO;
import mvc.Model.DAL.Sections.SectionDAO;
import mvc.Model.DAL.Status.IStatusDAO;
import mvc.Model.DAL.Status.StatusDAO;

public class PrimaryModel implements IModel{
    private PropertyChangeSupport support;
    private ISectionDAO iSectionDAO;
    private IStatusDAO iStatusDAO;

    public PrimaryModel(){
        this.support = new PropertyChangeSupport(this);
        this.iSectionDAO = new SectionDAO("jdbc:postgresql://localhost/ue1396", "postgres", "MDP");
        this.iStatusDAO = new StatusDAO("jdbc:postgresql://localhost/ue1396", "postgres", "MDP");
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public void getAllSection(){
        ArrayList<Section> sections = this.iSectionDAO.getSections();
        ArrayList<String> sectionsName = new ArrayList<>();
        for (Section section : sections) {
            sectionsName.add(section.getNom());
        }
        support.firePropertyChange("listeSection", "", sectionsName);        
    }

    @Override
    public void getSection(String sectionName){
        int id = this.iSectionDAO.getIDSection(sectionName);
        ArrayList<String> infoSection = new ArrayList<>();
        infoSection.add(Integer.toString(id));
        infoSection.add(sectionName);
        support.firePropertyChange("sectionSelected", "", infoSection );
    }

    @Override
    public void deleteSection(String id) {
        this.iSectionDAO.deleteSection(Integer.parseInt(id));
        this.getAllSection();
    }

    @Override
    public void updateSection(String id, String nom) {
        this.iSectionDAO.updateSection(Integer.parseInt(id), nom);
        this.getSection(nom);
    }

    @Override
    public void insertSection(String nom) {
        this.iSectionDAO.addSection(nom);
        this.getSection(nom);
    }

    @Override
    public void close() {
        this.iSectionDAO.close();
    }

    /// Status

    @Override
    public void getAllStatus()
    {
        ArrayList<Status> status = this.iStatusDAO.getStatus();
        ArrayList<String> statusName = new ArrayList<>();
        for (Status statue : status) {
            statusName.add(statue.getNom());
        }
        support.firePropertyChange("listeStatus", "", statusName);
    }

    @Override
    public void getStatus(String statusName)
    {
        int id = this.iStatusDAO.getIDStatus(statusName);
        ArrayList<String> infoStatus = new ArrayList<>();
        infoStatus.add(Integer.toString(id));
        infoStatus.add(statusName);
        support.firePropertyChange("statusSelected", "", infoStatus);
    }

    @Override
    public void deleteStatus(String id)
    {
        this.iStatusDAO.deleteStatus(Integer.parseInt(id));
        this.getAllStatus();
    }

    @Override
    public void updateStatus(String id, String status)
    {
        this.iStatusDAO.updateStatus(Integer.parseInt(id), status);
        this.getStatus(status);
    }

    @Override
    public void insertStatus(String status)
    {
        this.iStatusDAO.addStatus(status);
        this.getStatus(status);
    }
}
