package service;
import dao.registerdao;
import bean.user;
public class registerservice {
private registerdao dao = new registerdao();
	
	/**
	 * �����û�ע��
	 * @param user
	 * @return
	 */
	public boolean register(user user) {
		boolean registerSuccess = false;
		
		registerSuccess = dao.register(user);//�ж��Ƿ�������ݿ�ɹ�
		
		return registerSuccess;
	}
}
