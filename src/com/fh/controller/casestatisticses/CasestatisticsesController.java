package com.fh.controller.casestatisticses;

import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.fh.util.Jurisdiction;
import com.fh.service.casestatisticses.CasestatisticsesService;

/** 
 * 类名称：AGGZTJ_DQ_3Controller
 * 创建人：FH 
 * 创建时间：2018-04-27
 */
@Controller
@RequestMapping(value="/casestatisticses")
public class CasestatisticsesController extends BaseController {
	
	String menuUrl = "casestatisticses/list.do"; //菜单地址(权限用)
	@Resource(name="casestatisticsesService")
	private CasestatisticsesService casestatisticsesService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, "新增AGGZTJ_DQ_3");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("AGGZTJ_DQ_3_ID", this.get32UUID());	//主键
		casestatisticsesService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		logBefore(logger, "删除AGGZTJ_DQ_3");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			casestatisticsesService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, "修改AGGZTJ_DQ_3");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		casestatisticsesService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page){
		logBefore(logger, "列表AGGZTJ_DQ_3");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		
		if(beginTime != null && !"".equals(beginTime)){
			pd.put("beginTime", beginTime);
		}else {
			beginTime = "2017-01-01 00:00:00";
			pd.put("beginTime", beginTime);
		}
		
		if(endTime != null && !"".equals(endTime)){
			pd.put("endTime", endTime);
		}else {
			endTime = DateUtil.getDay() + " 23:59:59";
			pd.put("endTime", endTime);
		}
		
		try{
			page.setPd(pd);
			List<PageData>	varList = casestatisticsesService.listAll(pd);	//列出AGGZTJ_DQ_3列表
			mv.setViewName("casestatisticses/casestatisticses_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 超链接1一级
	 */
	@RequestMapping(value="/listbyCount")
	public ModelAndView listbyCount(){
		logBefore(logger, "去修改YHSL页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String DWBM = pd.getString("DWBM");
		
		if(null != DWBM && !"".equals(DWBM)){
			DWBM = DWBM.trim();
			pd.put("DWBM", DWBM);
		}
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		
		if(beginTime != null && !"".equals(beginTime)){
			pd.put("beginTime", beginTime);
		}else {
			beginTime = "2017-01-01 00:00:00";
			pd.put("beginTime", beginTime);
		}
		
		if(endTime != null && !"".equals(endTime)){
			pd.put("endTime", endTime);
		}else {
			endTime = DateUtil.getDay() + " 23:59:59";
			pd.put("endTime", endTime);
		}
		
		try {
			List<PageData>	varList = casestatisticsesService.listbyCount(pd);	//根据ID读取
			mv.setViewName("casestatisticses/ajtjaddressyj_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 超链接2一级
	 */
	@RequestMapping(value="/listbyConclude")
	public ModelAndView listbyConclude(){
		logBefore(logger, "去修改YHSL页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String DWBM = pd.getString("DWBM");
		
		if(null != DWBM && !"".equals(DWBM)){
			DWBM = DWBM.trim();
			pd.put("DWBM", DWBM);
		}
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		
		if(beginTime != null && !"".equals(beginTime)){
			pd.put("beginTime", beginTime);
		}else {
			beginTime = "2017-01-01 00:00:00";
			pd.put("beginTime", beginTime);
		}
		
		if(endTime != null && !"".equals(endTime)){
			pd.put("endTime", endTime);
		}else {
			endTime = DateUtil.getDay() + " 23:59:59";
			pd.put("endTime", endTime);
		}
		
		try {
			List<PageData>	varList = casestatisticsesService.listbyConclude(pd);	//根据ID读取
			mv.setViewName("casestatisticses/ajtjaddressyj_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	/**
	 * 超链接1
	 */
	@RequestMapping(value="/listbyCountEJ")
	public ModelAndView listbyCountEJ(){
		logBefore(logger, "去修改YHSL页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String DWBM = pd.getString("DWBM");
		
		if(null != DWBM && !"".equals(DWBM)){
			DWBM = DWBM.trim();
			pd.put("DWBM", DWBM);
		}
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		
		if(beginTime != null && !"".equals(beginTime)){
			pd.put("beginTime", beginTime);
		}else {
			beginTime = "2017-01-01 00:00:00";
			pd.put("beginTime", beginTime);
		}
		
		if(endTime != null && !"".equals(endTime)){
			pd.put("endTime", endTime);
		}else {
			endTime = DateUtil.getDay() + " 23:59:59";
			pd.put("endTime", endTime);
		}
		
		try {
			List<PageData>	varList = casestatisticsesService.listbyCountEJ(pd);	//根据ID读取
			mv.setViewName("casestatisticses/ajtjaddress_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 超链接2
	 */
	@RequestMapping(value="/listbyConcludeEJ")
	public ModelAndView listbyConcludeEJ(){
		logBefore(logger, "去修改YHSL页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String DWBM = pd.getString("DWBM");
		
		if(null != DWBM && !"".equals(DWBM)){
			DWBM = DWBM.trim();
			pd.put("DWBM", DWBM);
		}
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		
		if(beginTime != null && !"".equals(beginTime)){
			pd.put("beginTime", beginTime);
		}else {
			beginTime = "2017-01-01 00:00:00";
			pd.put("beginTime", beginTime);
		}
		
		if(endTime != null && !"".equals(endTime)){
			pd.put("endTime", endTime);
		}else {
			endTime = DateUtil.getDay() + " 23:59:59";
			pd.put("endTime", endTime);
		}
		
		try {
			List<PageData>	varList = casestatisticsesService.listbyConcludeEJ(pd);	//根据ID读取
			mv.setViewName("casestatisticses/ajtjaddress_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		logBefore(logger, "去新增AGGZTJ_DQ_3页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("casestatisticses/aggztj_dq_3/aggztj_dq_3_edit");
			mv.addObject("msg", "save");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		logBefore(logger, "去修改AGGZTJ_DQ_3页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = casestatisticsesService.findById(pd);	//根据ID读取
			mv.setViewName("casestatisticses/aggztj_dq_3/aggztj_dq_3_edit");
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() {
		logBefore(logger, "批量删除AGGZTJ_DQ_3");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "dell")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				casestatisticsesService.deleteAll(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, "导出AGGZTJ_DQ_3到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("单位名称");	//1
			titles.add("案件数量（件）");	//2
			titles.add("案件办结（件）");	//3
			dataMap.put("titles", titles);
			List<PageData> varOList = casestatisticsesService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
				vpd.put("var1", varOList.get(i).getString("DWMC"));	//1
				vpd.put("var2", varOList.get(i).getString("AJSLSB"));	//2
				vpd.put("var3", varOList.get(i).getString("AJBJSB"));	//3
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
