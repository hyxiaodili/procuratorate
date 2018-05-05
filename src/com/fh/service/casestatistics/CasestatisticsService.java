package com.fh.service.casestatistics;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("casestatisticsService")
public class CasestatisticsService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("CasestatisticsMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("CasestatisticsMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("CasestatisticsMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.listAll", pd);
	}
	
	/*
	 *超链接1
	 */
	public List<PageData> listbyCount(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.listbyCount", pd);
	}
	
	public List<PageData> listbyCountEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.listbyCountEJ", pd);
	}
	
	/*
	 *超链接2
	 */
	public List<PageData> listbyConclude(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.listbyConclude", pd);
	}
	
	public List<PageData> listbyConcludeEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsMapper.listbyConcludeEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CasestatisticsMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CasestatisticsMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

