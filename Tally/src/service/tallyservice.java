package service;
import dao.tallydao;
import bean.tally;
import bean.user;
public class tallyservice {
tallydao dao = new tallydao();
/**
 * �����û�����
 * @param tally
 * @return
 */
public boolean tally(tally tally) {
	boolean tallySuccess = false;
	
	tallySuccess = dao.tally(tally);//�ж��Ƿ�������ݿ�ɹ�
	
	return tallySuccess;
}
}
