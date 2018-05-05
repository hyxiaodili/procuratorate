package com.fh.service.testauthenticate;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("testauthenticateService")
public class TestauthenticateService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("TestauthenticateMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("TestauthenticateMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("TestauthenticateMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("TestauthenticateMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TestauthenticateMapper.listAll", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> testauthenticate(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TestauthenticateMapper.testauthenticate", pd);
	}
	
	public List<PageData> testauthenticateEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TestauthenticateMapper.testauthenticateEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("TestauthenticateMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("TestauthenticateMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

