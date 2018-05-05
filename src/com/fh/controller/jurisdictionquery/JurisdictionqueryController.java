package com.fh.controller.jurisdictionquery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.service.jurisdictionquery.JurisdictionqueryService;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/** 
 * 类名称：SJLXController
 * 创建人：FH 
 * 创建时间：2018-04-25
 */
@Controller
@RequestMapping(value="/jurisdictionquery")
public class JurisdictionqueryController extends BaseController {
	
	String menuUrl = "jurisdictionquery/list.do"; //菜单地址(权限用)
	@Resource(name="jurisdictionqueryService")
	private JurisdictionqueryService jurisdictionqueryService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("jurisdictionquery/jurisdictionquery_list");
		return mv;
	}
	
	/**
	 * 待分配案件检索
	 */
	@RequestMapping(value="/searching")
	public ModelAndView searching(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String field1 = pd.getString("field1");
		
		String field2 = pd.getString("field2");
		if(null != field1 && !"".equals(field1)){
			field1 = field1.trim();
			pd.put("field1", field1);
		}
		try{
			//待分配案件
			if(field2.equals("1")) {
				List<PageData>	varList = jurisdictionqueryService.searching(pd);
				mv.setViewName("jurisdictionquery/jurisdictionquery_list");
				mv.addObject("varList", varList);
				mv.addObject("pd", pd);
				mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
			}
			//确定承办人
			if(field2.equals("2")) {
				List<PageData>	varList = jurisdictionqueryService.searchingForAgent(pd);
				mv.setViewName("jurisdictionquery/jurisdictionquery_list");
				mv.addObject("varList", varList);
				mv.addObject("pd", pd);
				mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
			}
			//待接受移送文书
			if(field2.equals("3")) {
				List<PageData>	varList = jurisdictionqueryService.searchingForWrit(pd);
				mv.setViewName("jurisdictionquery/jurisdictionquery_list");
				mv.addObject("varList", varList);
				mv.addObject("pd", pd);
				mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
			}
			//待批案件
			if(field2.equals("4")) {
				List<PageData>	varList = jurisdictionqueryService.searchingForCase(pd);
				mv.setViewName("jurisdictionquery/jurisdictionquery_list");
				mv.addObject("varList", varList);
				mv.addObject("pd", pd);
				mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
			}
			//待接受反馈
			if(field2.equals("5")) {
				List<PageData>	varList = jurisdictionqueryService.searchingForFeedback(pd);
				mv.setViewName("jurisdictionquery/jurisdictionquery_list");
				mv.addObject("varList", varList);
				mv.addObject("pd", pd);
				mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
			}
			mv.setViewName("jurisdictionquery/jurisdictionquery_list");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, "导出SJLX到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("事件类别");	//1
			titles.add("工单");	//2
			dataMap.put("titles", titles);
			List<PageData> varOList = jurisdictionqueryService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("SJMC"));	//1
				vpd.put("var2", varOList.get(i).getString("SJSL"));	//2
				varList.add(vpd);
			}
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView();
			mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
