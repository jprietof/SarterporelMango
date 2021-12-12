package co.edu.usa.sarterporelmango.model.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.usa.sarterporelmango.model.Order;

/**
 * 
 * @author jprietof
 *
 */
public interface IOrder extends CrudRepository<Order, Integer> {
	@Query("{'salesMan.zone': ?0}")
	List<Order> findByZone(final String country);
	
	@Query("{status: ?0}")
	List<Order> findByStatus(final String status);
}
