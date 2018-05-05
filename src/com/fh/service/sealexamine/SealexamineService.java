package com.fh.service.sealexamine;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("sealexamineService")
public class SealexamineService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("SealexamineMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("SealexamineMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("SealexamineMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("SealexamineMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SealexamineMapper.listAll", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> listbySealexamine(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SealexamineMapper.listbySealexamine", pd);
	}
	
	public List<PageData> listbySealexamineEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SealexamineMapper.listbySealexamineEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("SealexamineMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("SealexamineMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

