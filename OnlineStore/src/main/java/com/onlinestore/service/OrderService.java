package com.onlinestore.service;
import com.onlinestore.model.*;
import com.onlinestore.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class OrderService {

	private final OrderRepository orderRepository;
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long id)
	{
		return orderRepository.findById(id).orElseThrow();
	}
	public Order createOrder(Order order)
	{
		return orderRepository.save(order);
	}
	
	public void deleteOrder(Long id)
	{
		orderRepository.deleteById(id);
	}
	
	public Order updateOrder(Long id, Order order)
	{
		Order o1=orderRepository.findById(id).orElseThrow();
		o1.setOrder_id(order.getOrder_id());
		o1.setUser(order.getUser());
		o1.setOrderitem(order.getOrderitem());
		o1.setTotalPrice(order.getTotalPrice());
		
		return orderRepository.save(o1);
		
		
	}

}
