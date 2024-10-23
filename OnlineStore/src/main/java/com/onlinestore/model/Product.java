package com.onlinestore.model;
import jakarta.persistence.*;
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	private Category category;
	private Integer quantity;
	
	
	public Long getProductId() { 
		return productId;
		
	}
	
	public void setProductId(Long productId)
	{
		this.productId=productId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public Integer getPrice()
	{
		return price;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category=category;
	}
	public Integer getQuantity()
	{ 
		return quantity;
		
	}
	public void setQuantity(Integer quantity)
	{
		this.quantity=quantity;
	}

}
