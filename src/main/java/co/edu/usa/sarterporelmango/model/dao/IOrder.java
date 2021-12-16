package co.edu.usa.sarterporelmango.model.dao;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import co.edu.usa.sarterporelmango.model.Order;

/**
 * 
 * @author jprietof
 *
 */
public interface IOrder extends MongoRepository<Order, Integer> {
	@Query("{'salesMan.zone': ?0}")
	List<Order> findByZone(final String country);
	
	@Query("{status: ?0}")
	List<Order> findByStatus(final String status);
	@Query("{'date' : { $gte: ?0, $lte: ?1 } }")                 
	List<Order> getObjectByDate(Date from, Date to); 
	/*List<Order> findByZone(String zone);
	List<Order> findBySalesManId(Integer id);
	List<Order> findByStatus(Integer id, String status);
	List<Order> findByRegisterDate(Date registerDay, Integer id);*/
}
