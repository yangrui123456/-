package cn.itcast;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.itcast.common.junit.SpringJunitTest;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;
import cn.itcast.core.service.product.BrandService;


public class TestBrand extends SpringJunitTest{
	@Autowired
	private BrandService brandService;
	
	@Test
	public void testGet() throws Exception {
		BrandQuery brandQuery = new BrandQuery();
		//brandQuery.setFields("id");
		//brandQuery.setNameLike(true);
		//brandQuery.setName("哈");
		brandQuery.orderById(false);//倒序
		brandQuery.setPageNo(2);//第二页
		brandQuery.setPageSize(4);//四条数据
		
		List<Brand> brands = brandService.getBrandList(brandQuery);
		
		for (Brand b : brands) {
			System.out.println(b);
		}
	}

}
