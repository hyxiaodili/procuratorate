package com.fh.service.casestandard;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("casestandardService")
public class CaseStandardService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CaseStandardMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseStandardMapper.listAll", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> findlistByCasetype(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseStandardMapper.findlistByCasetype", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> listbyidCasetypeEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseStandardMapper.listbyidCasetypeEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CaseStandardMapper.findById", pd);
	}
	
	
}

