package service;

import java.util.List;

import pojo.Paid;
import pojo.QueryVo;
import pojo.Topaid;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id, Paid paid);
}
