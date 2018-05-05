package com.fh.service.datedit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("dateditService")
public class DateditService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("DateditMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("DateditMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("DateditMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("DateditMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("DateditMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DateditMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("DateditMapper.deleteAll", ArrayDATA_IDS);
	}
	
	public  List<PageData> listbyAccept(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("DateditMapper.listbyAccept", pd);
	}
	
	public  List<PageData> listbyConclude(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("DateditMapper.listbyConclude", pd);
	}
	
	public  List<PageData> listbyExpire(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("DateditMapper.listbyExpire", pd);
	}
}

