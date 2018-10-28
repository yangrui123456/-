package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;

public interface BrandDao {
	//list集合
	public List<Brand> getBrandListWithPage(Brand brand);
	//brandQuery对象查询list集合
	public List<Brand> getBrandList(BrandQuery brandQuery);
	//查询总记录数
	public int getBrandCount(Brand brand);
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
