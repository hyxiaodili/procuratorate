package com.fh.service.systemload;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("systemloadService")
public class SystemloadService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("SystemloadMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("SystemloadMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("SystemloadMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("SystemloadMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SystemloadMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("SystemloadMapper.findById", pd);
	}
	
	public  List<PageData> listbyAdministratorcount(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("SystemloadMapper.listbyAdministratorcount", pd);
	}
	
	public  List<PageData> listbyUnitname(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("SystemloadMapper.listbyUnitname", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("SystemloadMapper.deleteAll", ArrayDATA_IDS);
	}
	/*
	* 通过id获取列表数据
	*/
	public  List<PageData> findlistById(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("YHSLMapper.findlistById", pd);
	}
	
}

