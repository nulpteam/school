package epam.ph.sg.models;

public interface LoginModelDAO {
	/**
	 * ������ ����� � ����
	 * 
	 * @param sql - sql �����
	 * @return ��������� User, ��� null ���� ���� ���� � ��
	 */
	User auth(String sql);
}
