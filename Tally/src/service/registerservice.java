package service;
import dao.registerdao;
import bean.user;
public class registerservice {
private registerdao dao = new registerdao();
	
	/**
	 * 用于用户注册
	 * @param user
	 * @return
	 */
	public boolean register(user user) {
		boolean registerSuccess = false;
		
		registerSuccess = dao.register(user);//判断是否存入数据库成功
		
		return registerSuccess;
	}
}
