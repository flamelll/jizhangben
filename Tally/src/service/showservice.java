package service;
import java.util.List;
import dao.showdao;
import bean.tally;
public class showservice {
	private showdao sd=new showdao();
	public List<tally> list() {
	    return sd.select();
	}
}
