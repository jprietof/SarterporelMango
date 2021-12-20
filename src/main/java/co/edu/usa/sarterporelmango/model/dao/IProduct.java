package co.edu.usa.sarterporelmango.model.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.usa.sarterporelmango.model.Product;

/**
 * 
 * @author jprietof
 *
 */
public interface IProduct extends MongoRepository<Product, String>{
	//Reto 5
	public List<Product> findByPriceLessThanEqual(double precio);
	
	//Reto 5
	@Query("{'description': {'$regex':'?0', '$options': 'i'}}")
	public List<Product> findByDescriptionLike(String description);
}
