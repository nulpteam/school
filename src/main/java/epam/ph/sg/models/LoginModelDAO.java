package epam.ph.sg.models;

import java.util.List;

public interface LoginModelDAO {
	List<User> getFromDB(String sql);

	String getTitle();
}
