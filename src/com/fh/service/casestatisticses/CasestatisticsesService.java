package com.fh.service.casestatisticses;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("casestatisticsesService")
public class CasestatisticsesService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("CasestatisticsesMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("CasestatisticsesMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("CasestatisticsesMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.listAll", pd);
	}
	
	/*
	 *超链接1
	 */
	public List<PageData> listbyCount(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.listbyCount", pd);
	}
	
	/*
	 *超链接2
	 */
	public List<PageData> listbyConclude(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.listbyConclude", pd);
	}
	/*
	 *超链接1二级
	 */
	public List<PageData> listbyCountEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.listbyCountEJ", pd);
	}
	
	/*
	 *超链接2二级
	 */
	public List<PageData> listbyConcludeEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CasestatisticsesMapper.listbyConcludeEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CasestatisticsesMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CasestatisticsesMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

