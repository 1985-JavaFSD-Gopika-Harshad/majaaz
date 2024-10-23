package com.onlinestore.controller;
import com.onlinestore.model.*;
import com.onlinestore.service.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	
	private final OrderService os;
	@Autowired
	public OrderController(OrderService os) {
		// TODO Auto-generated constructor stub
	this.os=os;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders()
	{
		return ResponseEntity.ok(os.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id)
	{
		return ResponseEntity.ok(os.getOrderById(id));
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order)
	{
		return ResponseEntity.ok(os.createOrder(order));
	}
	
	@PutMapping
	public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order)
	{
		return ResponseEntity.ok(os.updateOrder(id, order));
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id)
	{
		os.deleteOrder(id);
     return		ResponseEntity.noContent().build();
	}
}
