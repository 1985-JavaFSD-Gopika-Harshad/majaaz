package com.onlinestore.model;
import jakarta.persistence.*;
@Entity
@Table(name="order_items")
public class OrderItem {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderItemId;
     
     @ManyToOne
     @JoinColumn(name="order_id",nullable=false)
     private Order order;
     
     @ManyToOne
     @JoinColumn(name="productId",nullable=false)
     private Product product;
     
     
     private Integer quantity;
     private Integer price;
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
     
     
     
     

}
