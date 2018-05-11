package com.fh.service.configureabnormal;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("configureabnormalService")
public class ConfigureabnormalService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("ConfigureabnormalMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("ConfigureabnormalMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("ConfigureabnormalMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ConfigureabnormalMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ConfigureabnormalMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ConfigureabnormalMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ConfigureabnormalMapper.deleteAll", ArrayDATA_IDS);
	}
	
	
	public  List<PageData> listbyUnitname(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyUnitname", pd);
	}
	
	public  List<PageData> listbyUnitforshort(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyUnitforshort", pd);
	}
	
	public  List<PageData> listbyUnitno(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyUnitno", pd);
	}

	public  List<PageData> listbyToacceptthewizard(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyToacceptthewizard", pd);
	}
	
	public  List<PageData> listbyCaseno(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyCaseno", pd);
	}
	
	public  List<PageData> listbyWritno(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyWritno", pd);
	}
	
	public  List<PageData> listbyMinimum(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyMinimum", pd);
	}
	
	public  List<PageData> listbyZonecontrol(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyZonecontrol", pd);
	}
	
	public  List<PageData> listbySecondlevel(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbySecondlevel", pd);
	}
	
	public  List<PageData> listbyThreelevel(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyThreelevel", pd);
	}

	public  List<PageData> listbyFourlevel(PageData pd)throws Exception{
		return  (List<PageData>)dao.findForList("ConfigureabnormalMapper.listbyFourlevel", pd);
	}
}

