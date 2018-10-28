package cn.itcast.core.query.product;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.core.web.Constants;


public class BrandQuery {
	private Integer id;
	private String name;
	private String description;
	private String imgUrl;
	private Integer sort;
	private Integer isDisplay;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	/******************************查询指定字段***********************************/
	private String fields;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	/******************************查询字段Like***********************************/
	private boolean nameLike;//默认情况为不给值，false
	public boolean isNameLike() {
		return nameLike;
	}
	public void setNameLike(boolean nameLike) {
		this.nameLike = nameLike;
	}
	/******************************order by ***********************************/
	public class FieldOrder{
		private String field; //id, name , imgUrl
		private String order; // desc , asc 
		
		public FieldOrder(String field, String order) {
			super();
			this.field = field;
			this.order = order;
		}
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
		
	}
	//order集合
	private List<FieldOrder> fieldOrders = new ArrayList<FieldOrder>();
	//按照id排序
	public void orderById(boolean isAsc){
		fieldOrders.add(new FieldOrder("id",isAsc == true ? "asc" : "desc"));
	}
	//按照name排序
	public void orderByName(boolean isAsc){
		fieldOrders.add(new FieldOrder("name", isAsc == true ? "asc" : "desc"));
	}
		//页码
		private Integer pageNo = 1;
		//开始行
		private Integer startRow;
		//每页数
		private Integer pageSize = 10;
		//获取全路径
		public String getAllUrl(){
			return Constants.IMAGE_URL + imgUrl;
		}
		
		
		public Integer getStartRow() {
			return startRow;
		}
		public void setStartRow(Integer startRow) {
			this.startRow = startRow;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			//计算第一次开始行
			this.startRow = (pageNo-1)*pageSize;
			this.pageSize = pageSize;
		}
		public Integer getPageNo() {
			return pageNo;
		}
		public void setPageNo(Integer pageNo) {
			this.startRow = (pageNo-1)*pageSize;
			this.pageNo = pageNo;
		}

}