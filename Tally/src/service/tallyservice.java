package service;
import dao.tallydao;
import bean.tally;
import bean.user;
public class tallyservice {
tallydao dao = new tallydao();
/**
 * 用于用户记账
 * @param tally
 * @return
 */
public boolean tally(tally tally) {
	boolean tallySuccess = false;
	
	tallySuccess = dao.tally(tally);//判断是否存入数据库成功
	
	return tallySuccess;
}
}
