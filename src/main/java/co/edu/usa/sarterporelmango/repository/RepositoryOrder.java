package co.edu.usa.sarterporelmango.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.edu.usa.sarterporelmango.model.Order;
import co.edu.usa.sarterporelmango.model.dao.IOrder;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * 
 * @author jprietof
 *
 */
@Repository
public class RepositoryOrder {
	 @Autowired
	 private IOrder orderCrudRepository;
	 
	 @Autowired
	 private MongoTemplate mongoTemplate;
	 
	 public List<Order> getAll(){
		 return (List<Order>) orderCrudRepository.findAll();
	 }
	 
	 public Optional<Order> getOrder(int id){
		 return orderCrudRepository.findById(id);
	 }
	 
	 public Order create(Order order) {
		 return orderCrudRepository.save(order);
	 }
	 
	 public void update(Order order) {
		 orderCrudRepository.save(order);
	 }
	 
	 public void delete(Order order) {
		 orderCrudRepository.delete(order);
	 }
	 
	 public List <Order> findByZone(String zona){
		 return orderCrudRepository.findByZone(zona);
	 }
	 
	 public List<Order> ordersSalesManByID(Integer id){
		 //return orderCrudRepository.findBySalesManId(id);
		 Query query = new Query();
		 Criteria dateCriteria = Criteria.where("salesMan.id").is(id);
		 query.addCriteria(dateCriteria);
		 List<Order> orders = mongoTemplate.find(query, Order.class);
		 return orders;
	 }
	 
	 public List<Order>  ordersSalesManByState(String state, Integer id){
		 //return orderCrudRepository.findByStatus(id, state);
		 Query query = new Query();
		 Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
				 .and("status").is(state);
		 
		 query.addCriteria(dateCriteria);
		 List<Order> orders = mongoTemplate.find(query, Order.class);
		 return orders;
	 }
	 
	 
	 public List<Order> ordersSalesManByDate(String dateStr, Integer id){
		 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        Query query = new Query();
	        
	        Criteria dateCriteria = Criteria.where("registerDay")
	        		.gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
	        		.lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
	        		.and("salesMan.id").is(id);
	       
	        query.addCriteria(dateCriteria);
	        
	        List<Order> orders = mongoTemplate.find(query, Order.class);
	        
	        return orders; 
		 /*try {
			 return orderCrudRepository.findByRegisterDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr),id);
		 } catch (ParseException e){
			 e.printStackTrace();
			 return null;
		 }*/
	 }
}
