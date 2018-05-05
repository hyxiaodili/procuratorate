package com.fh.service.skillevidenceinvestigate;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("skillevidenceinvestigateService")
public class SkillevidenceinvestigateService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("SkillevidenceinvestigateMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("SkillevidenceinvestigateMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("SkillevidenceinvestigateMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("SkillevidenceinvestigateMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SkillevidenceinvestigateMapper.listAll", pd);
	}
	
	/*
	 *超链接
	 */
	public List<PageData> listbySkillevidenceinvestigate(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SkillevidenceinvestigateMapper.listbySkillevidenceinvestigate", pd);
	}
	
	public List<PageData> listbySkillevidenceinvestigateEJ(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SkillevidenceinvestigateMapper.listbySkillevidenceinvestigateEJ", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("SkillevidenceinvestigateMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("SkillevidenceinvestigateMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

