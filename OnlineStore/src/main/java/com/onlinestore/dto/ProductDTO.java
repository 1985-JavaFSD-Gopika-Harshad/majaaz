package com.onlinestore.dto;

public class ProductDTO {

	private Long productId;
	private String name;
	private Integer price;
	private Long category_id;
	private Integer quantity;
	
	
	
	public Long getProductId()
	{
		return productId;
	}
	public void setProductId(Long productId)
	{
		this.productId=productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
