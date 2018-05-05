package com.fh.service.casereal;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("caseRealService")
public class CaseRealService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("CaseRealMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("CaseRealMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("CaseRealMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CaseRealMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseRealMapper.listAll", pd);
	}
	
	/*
	 *列表(全部)
	 */
	public List<PageData> listbyCasereal(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseRealMapper.listbyCasereal", pd);
	}
	
	public List<PageData> listbyCaserealEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CaseRealMapper.listbyCaserealEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CaseRealMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CaseRealMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

