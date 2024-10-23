package com.onlinestore.model;
import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
