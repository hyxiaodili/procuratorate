package com.fh.controller.majorreal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.fh.entity.Page;
import com.fh.service.majorreal.MajorRealService;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.PageData;

/** 
 * 类名称：AGGZTJ_DQ_3Controller
 * 创建人：FH 
 * 创建时间：2018-04-03
 */
@Controller
@RequestMapping(value="/majorreal")
public class MajorRealController extends BaseController {
	
	String menuUrl = "majorreal/list.do"; //菜单地址(权限用)
	@Resource(name="majorRealService")
	private MajorRealService majorRealService;
	
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
		String field1 = pd.getString("field1");
		
		if(null != field1 && !"".equals(field1)){
			field1 = field1.trim();
			pd.put("field1", field1);
		}else {
			field1 = "";
			pd.put("field1", field1);
		}
		
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
			List<PageData>	varList = majorRealService.listAll(pd);	//列出AGGZTJ_DQ_3列表
			mv.setViewName("majorreal/majorreal_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 超链接一级
	 */
	@RequestMapping(value="/listbyMajorreal")
	public ModelAndView listbyMajorreal(Page page){
		logBefore(logger, "列表AGGZTJ_DQ_3");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String beginTime = pd.getString("beginTime");
		String endTime = pd.getString("endTime");
		String field1 = pd.getString("field1");
		String DWMC = pd.getString("DWMC");
		
		if(null != DWMC && !"".equals(DWMC)){
			DWMC = DWMC.trim();
			pd.put("DWMC", DWMC);
		}
		
		if(null != field1 && !"".equals(field1)){
			field1 = field1.trim();
			pd.put("field1", field1);
		}else {
			field1 = "";
			pd.put("field1", field1);
		}
		
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
			List<PageData>	varList = majorRealService.listbyMajorreal(pd);	//列出AGGZTJ_DQ_3列表
			mv.setViewName("majorreal/sjzyyj_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 单位名称超链接
	 */
	@RequestMapping(value="/listbyInvolvemajorEJ")
	public ModelAndView listbyInvolvemajorEJ(){
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
			List<PageData>	varList = majorRealService.listbyInvolvemajorEJ(pd);	//根据ID读取
			mv.setViewName("majorreal/sjzy_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch (Exception e) {
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
