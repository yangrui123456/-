package cn.itcast.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.product.BrandService;

/*
 * 品牌
 */
@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	//品牌列表页面
	@RequestMapping(value="/brand/list.do")
	public String list(String name ,Integer isDisplay,Integer pageNo,ModelMap model){
				//构建参数，    params：装参数的
				StringBuilder params = new StringBuilder(); 
				Brand brand = new Brand();
			//判断传进了的值是否为空，并且还要判断是否为空串   isBlank "" "    "都包含     isEmtpy "" ,"    "后面这个不包含
			if (StringUtils.isNotBlank(name)) {
				brand.setName(name);
				params.append("name=").append(name);
			}
			if (null != isDisplay) {
				brand.setIsDisplay(isDisplay);
				params.append("&").append("isDisplay=").append(isDisplay);
			}else {
				brand.setIsDisplay(1);
				params.append("&").append("isDisplay=").append(1);
			}
			
			
			
			//页号                         Pagination.cpn的作用是如果页号为null，或者小于1，置为1
			brand.setPageNo(Pagination.cpn(pageNo));
			//设置每页数
			brand.setPageSize(5);
			//分页对象
			Pagination pagination = brandService.getBrandListWithPage(brand);
			
			//分页展示        /brand/list.do?name=兰博伊人（lanboyiren） & isDisplay=1 & pageNo=2
			String url = "/brand/list.do";
			pagination.pageView(url, params.toString());
			
			model.addAttribute("pagination", pagination);//MadelMap的底层原理就是 request.setAttribute
			model.addAttribute("name", name);
			model.addAttribute("isDisplay",isDisplay);
			
			return"brand/list";
	}
	//跳转到品牌添加页面
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}
	//添加品牌
	@RequestMapping(value = "/brand/add.do")
	public String add(Brand brand){
		//
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}
	//删除一个品牌
	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id,String name,Integer isDisplay,ModelMap model){
		brandService.deleteBrandByKey(id);
		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
		}
		if (null != isDisplay) {
			model.addAttribute("isDisplay", isDisplay);
		}
		
		return "redirect:/brand/list.do";
	}
	//批量删除
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Integer[] ids,String name,Integer isDisplay,ModelMap model){
		brandService.deleteBrandByKeys(ids);
		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
		}
		if (null != isDisplay) {
			model.addAttribute("isDisplay", isDisplay);
		}
		
		return "redirect:/brand/list.do";
	}
	//去修改页面
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Integer id,ModelMap model){
		Brand brand = brandService.getBrandByKey(id);
		model.addAttribute("brand", brand);
		return "/brand/edit";
	}
	//修改页面
	@RequestMapping(value="/brand/edit.do")
	public String edit(Brand brand,ModelMap model){
		brandService.updateBrandByKey(brand);
		return "redirect:/brand/list.do";
	}
}
