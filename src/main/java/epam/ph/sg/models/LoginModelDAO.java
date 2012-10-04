package epam.ph.sg.models;

public interface LoginModelDAO {
	/**
	 * Витягує юзера з бази
	 * 
	 * @param sql - sql запит
	 * @return Екземпляр User, або null якщо його нема в БД
	 */
	User auth(String sql);
}
