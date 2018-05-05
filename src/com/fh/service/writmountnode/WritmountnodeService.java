package com.fh.service.writmountnode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

@Service("writmountnodeService")
public class WritmountnodeService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WritmountnodeMapper.listAll", pd);
	}
	
	/*
	 *检索
	 */
	public List<PageData> searching(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WritmountnodeMapper.searching", pd);
	}
}