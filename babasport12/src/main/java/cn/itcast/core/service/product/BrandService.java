package cn.itcast.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;
/*
 * 品牌
 */
public interface BrandService {
	public Pagination getBrandListWithPage(Brand brand);
	//查询集合
	public List<Brand> getBrandList(BrandQuery brandQuery);

	//添加品牌
	public void addBrand(Brand brand);
	//删除一个品牌
	public void deleteBrandByKey(Integer id);
	//批量 删除
	public void deleteBrandByKeys(Integer[] ids);
	//修改
	public void updateBrandByKey(Brand brand);
	//通过id查询对象
	public Brand getBrandByKey(Integer id);
}
