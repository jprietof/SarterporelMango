package co.edu.usa.sarterporelmango.model.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.usa.sarterporelmango.model.Product;

/**
 * 
 * @author jprietof
 *
 */
public interface IProduct extends MongoRepository<Product, String>{

}
