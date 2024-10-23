package com.onlinestore.model;
import jakarta.persistence.*;


import java.util.List;
@Entity
@Table(name="orders")
public class Order {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long order_id;

@ManyToOne
@JoinColumn(name="user_id",nullable=false)
private User user;

@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
private List<OrderItem> orderitem;

private Integer totalPrice;


public Long getOrderId()
{
	return order_id;
}

public void setOrderId(Long order_id)
{
	this.order_id=order_id;
}

public User getUser()
{
	return user;
}

public void setUser(User user)
{
	this.user=user;
}

public Long getOrder_id() {
	return order_id;
}

public void setOrder_id(Long order_id) {
	this.order_id = order_id;
}

public List<OrderItem> getOrderitem() {
	return orderitem;
}

public void setOrderitem(List<OrderItem> orderitem) {
	this.orderitem = orderitem;
}

public List<OrderItem> getOrderItem()
{
	return orderitem;
}

public Integer getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(Integer totalPrice)
{
	this.totalPrice=totalPrice;
}
}
