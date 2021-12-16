package co.edu.usa.sarterporelmango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import co.edu.usa.sarterporelmango.model.Order;
import co.edu.usa.sarterporelmango.repository.RepositoryOrder;

/**
 * 
 * @author jprietof
 *
 */
@Service
public class ServiceOrder {
	@Autowired
	private RepositoryOrder orderRepository;
	
	public List<Order> getAll(){
		return orderRepository.getAll();
	}
	
	public Optional<Order> getOrder(int id){
		return orderRepository.getOrder(id);
	}
	
	public Order create(Order order) {
		if(order.getId() == null) {
			return order;
		}else {
			return orderRepository.create(order);
		}
	}
	
	public Order update(Order order) {
		if(order.getId() !=null) {
			Optional<Order>orderDb = orderRepository.getOrder(order.getId());
			if(!orderDb.isEmpty()) {
				if(order.getStatus() !=null) {
					orderDb.get().setStatus(order.getStatus());
				}
				orderRepository.update(orderDb.get());
				return orderDb.get();
			}else {
				return order;
			}
		}else {
			return order;
		}
	}
	
	public boolean delete(int id) {
		Boolean aBoolean = getOrder(id).map(order->{
			orderRepository.delete(order);
			return true;
		}).orElse(false);
		return aBoolean;
	}
	
	public List<Order> findByZone(String zona){
		return orderRepository.findByZone(zona);
	}
	
	public List<Order> orderSalesManByID(int id){
		return orderRepository.ordersSalesManByID(id);
	}
	
	public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr,id);
    }
	
	public List<Order> orderSalesManByState(String state, Integer id){
		return orderRepository.ordersSalesManByState(state, id);
	}
}
