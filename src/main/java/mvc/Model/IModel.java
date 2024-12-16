package mvc.Model;

import java.beans.PropertyChangeListener;

public interface IModel {
    public void addPropertyChangeListener(PropertyChangeListener pcl);
    public void removePropertyChangeListener(PropertyChangeListener pcl);
    public void getAllSection();
    public void getSection(String sectionName);
    public void deleteSection(String id);
    public void updateSection(String id, String nom); 
    public void insertSection(String nom);
    public void getAllStatus();
    public void getStatus(String status);
    public void deleteStatus(String id);
    public void updateStatus(String id, String status);
    public void insertStatus(String status);
    public void close();
}
