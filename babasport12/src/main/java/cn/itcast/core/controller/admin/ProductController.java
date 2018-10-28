package cn.itcast.core.controller.admin;

import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.Color;
import cn.itcast.core.bean.product.Feature;
import cn.itcast.core.bean.product.Img;
import cn.itcast.core.bean.product.Product;
import cn.itcast.core.bean.product.Type;
import cn.itcast.core.query.product.BrandQuery;
import cn.itcast.core.query.product.ColorQuery;
import cn.itcast.core.query.product.FeatureQuery;
import cn.itcast.core.query.product.ProductQuery;
import cn.itcast.core.query.product.TypeQuery;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.service.product.ColorService;
import cn.itcast.core.service.product.FeatureService;
import cn.itcast.core.service.product.ProductService;
import cn.itcast.core.service.product.TypeService;



/*
 * 商品管理
 * 商品列表
 * 商品添加
 * 商品上架
 */
@Controller
public class ProductController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;//商品类型
	@Autowired
	private FeatureService featureService;//商品属性
	@Autowired
	private ColorService colorService;//商品颜色
	//商品列表
	@RequestMapping(value ="/product/list.do")
	public String list(Integer pageNo,String name,Integer brandId,Integer isShow,ModelMap model){
		//加载品牌
		BrandQuery brandQuery = new BrandQuery();
		//指定查询字段
		brandQuery.setFields("id,name");
		//设置可见
		brandQuery.setIsDisplay(1);
		List<Brand> brands = brandService.getBrandList(brandQuery);
		//品牌列表展示
		model.addAttribute("brands", brands);
		
		//设置分页参数
		StringBuilder params = new StringBuilder();
		
		//商品条件对象
		ProductQuery productQuery = new ProductQuery();
		//判断条件为null
		if (StringUtils.isNotBlank(name)) {
			productQuery.setName(name);
			//要求模糊查询
			productQuery.setNameLike(true);
			params.append("name=").append(name);
			
			//回显查询条件
			model.addAttribute("name",name);
		}
		if(null != brandId){
			productQuery.setBrandId(brandId);
			params.append("&").append("brandId=").append(brandId);
			//回显查询条件
			model.addAttribute("brandId", brandId);
			
		}
		if(null != isShow){
			productQuery.setIsShow(isShow);
			params.append("&").append("isShow=").append(isShow);
			model.addAttribute("isShow",isShow);
		}else {
			productQuery.setIsShow(0);
			params.append("&").append("isShow").append(0);
			model.addAttribute("isShow",0);
		}
		//设置页号，查询分页;
		productQuery.setPageNo(Pagination.cpn(pageNo));
		productQuery.setPageSize(5);
		//加载带有分页的商品
		Pagination pagination = productService.getProductListWithPage(productQuery);
		//页面展示
		String url = "/product/list.do";
		pagination.pageView(url,params.toString());
		
		model.addAttribute("pagination", pagination);
		//分页页面显示
		return "product/list";
		
	}
	//跳转到商品添加页面
	@RequestMapping(value="/product/toAdd.do")
	public String toAdd(ModelMap model){
		//1.加载商品类型
		TypeQuery typeQuery = new TypeQuery();
		//指定查询那些字段
		typeQuery.setFields("id,name");
		//不可见得不要
		typeQuery.setIsDisplay(1);
		//父id是0 的不加载  xml已经改成了！
		typeQuery.setParentId(0);
		List<Type> types = typeService.getTypeList(typeQuery);
		//类型显示在页面
		model.addAttribute("types", types);
		
		//2.加载品牌  品牌条件对象
		BrandQuery brandQuery = new BrandQuery();
		//指定查询字段
		brandQuery.setFields("id,name");
		//设置可见
		brandQuery.setIsDisplay(1);
		List<Brand> brands = brandService.getBrandList(brandQuery);
		//品牌列表展示
		model.addAttribute("brands", brands);
		
		//3.加载商品属性
		FeatureQuery featureQuery = new FeatureQuery();
		List<Feature> features = featureService.getFeatureList(featureQuery);
		model.addAttribute("features", features);
		
		//4.加载商品颜色
		ColorQuery colorQuery = new ColorQuery();
		colorQuery.setParentId(0);
		List<Color> colors = colorService.getColorList(colorQuery);
		model.addAttribute("colors", colors);
		return "product/add";
	}
	//添加商品
	@RequestMapping(value = "/product/add.do")
	public String add(Product product,Img img){
		//商品表  图片表 sku表
		product.setImg(img);
		//传商品对象到service
		productService.addProduct(product);
		return "redirect:/product/list.do";
	}
}
