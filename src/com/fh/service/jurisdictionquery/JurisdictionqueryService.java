package com.fh.service.jurisdictionquery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.util.PageData;

@Service("jurisdictionqueryService")
public class JurisdictionqueryService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.listAll", pd);
	}
	
	/*
	 *待分配案件检索
	 */
	public List<PageData> searching(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.searching", pd);
	}
	/*
	 *确定承办人
	 */
	public List<PageData> searchingForAgent(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.searchingForAgent", pd);
	}
	/*
	 *待接收移送文书
	 */
	public List<PageData> searchingForWrit(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.searchingForWrit", pd);
	}
	/*
	 *待批案件
	 */
	public List<PageData> searchingForCase(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.searchingForCase", pd);
	}
	/*
	 *待接收反馈
	 */
	public List<PageData> searchingForFeedback(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("JurisdictionqueryMapper.searchingForFeedback", pd);
	}
}