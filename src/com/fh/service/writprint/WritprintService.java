package com.fh.service.writprint;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("writprintService")
public class WritprintService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("WritprintMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("WritprintMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("WritprintMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("WritprintMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WritprintMapper.listAll", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> listbyWritprint(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WritprintMapper.listbyWritprint", pd);
	}
	
	public List<PageData> listbyWritprintEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WritprintMapper.listbyWritprintEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("WritprintMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("WritprintMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

