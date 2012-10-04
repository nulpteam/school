package epam.ph.sg.models;


public interface LoginModelDAO {
	User auth(String sql);

	String getTitle();
}
