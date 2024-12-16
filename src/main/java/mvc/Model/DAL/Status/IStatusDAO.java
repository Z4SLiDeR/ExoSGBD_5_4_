package mvc.Model.DAL.Status;

import java.util.ArrayList;
import mvc.Model.BL.Status;

public interface IStatusDAO {

    public ArrayList<Status> getStatus();

    public int getIDStatus(String nom);

    public boolean updateStatus(int id, String nom);

    public boolean deleteStatus(int id);

    public boolean addStatus(String nom);

    public void close();
}
