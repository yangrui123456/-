package cn.itcast.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.query.product.BrandQuery;
/*
 * 品牌事务
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	@Resource
	private BrandDao brandDao;
	
	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand){
		//1起始页		StartRow = (PageNo-1)*PageSize
		//2每页数
		//3总页数
		Pagination pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//设置品牌查询的集合
		pagination.setList(brandDao.getBrandListWithPage(brand));
		
		return pagination;
	}

	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	@Override
	public void deleteBrandByKey(Integer id) {
		// TODO Auto-generated method stub
		brandDao.deleteBrandByKey(id);
	}
	
	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		// TODO Auto-generated method stub
		brandDao.deleteBrandByKeys(ids);
	}
	
	@Override
	public void updateBrandByKey(Brand brand) {
		// TODO Auto-generated method stub
		brandDao.updateBrandByKey(brand);
	}

	@Override
	public Brand getBrandByKey(Integer id) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByKey(id);
	}
	
	@Override
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		
		return brandDao.getBrandList(brandQuery);
	}

	

	
	
	
}
