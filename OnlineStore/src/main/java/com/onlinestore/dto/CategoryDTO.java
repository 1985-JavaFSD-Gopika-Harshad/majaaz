package com.onlinestore.dto;

public class CategoryDTO {

	private Long category_id;
	private String category_name;
	public Long getCategoryId()
	{
		return category_id;
	}
	public void setCategoryId(Long category_id)
	{
		this.category_id=category_id;
	}
	
	public String getCategoryName() {
		return category_name;
	}
	public void setCategoryName(String category_name)
	{
		this.category_name=category_name;
	}
}
