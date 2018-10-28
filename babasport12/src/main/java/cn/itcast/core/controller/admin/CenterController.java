package cn.itcast.core.controller.admin;

import java.util.Date;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理
 * 测试
 * @author ASUS
 *
 */
@Controller
@RequestMapping(value="/control")
public class CenterController {
	//每一个springmvc
	@RequestMapping(value="/test/springmvc.do")
	public String test(String name,Date birthday){
		
		System.out.println();
		return "";
	}

	//只能这个Controller使用这个日期转换 ，属于局部日期转换
	/*@InitBinder			
	public void initBinder(WebDataBinder binder, WebRequest request) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/
	
	//跳转入口页面
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}       

	//跳转头页面
	@RequestMapping(value="/top.do")
	public String top(){
		return "top";
	}  
	
	//跳转身体页面
	@RequestMapping(value="/main.do")
	public String main(){
		return "main";
	}    
	
	//跳转左页面
	@RequestMapping(value="/left.do")
	public String left(){
		return "left";
	}  
	
	//跳转右页面
	@RequestMapping(value="/right.do")
	public String right(){
		return "right";
	}    

}
